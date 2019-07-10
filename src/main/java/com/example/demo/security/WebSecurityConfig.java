package com.example.demo.security;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zfd
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    /**
     * configure(HttpSecurity security 主要配置资源的访问权限)
     * @param security
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf().disable();
        security.authorizeRequests().
                antMatchers("/css/**","/img/**","/js/**").permitAll().
                antMatchers("/operateDriver").hasRole("ADMIN").
                antMatchers("/user").hasRole("USER").
                and().
                formLogin().loginPage("/login").
                successForwardUrl("/index").failureForwardUrl("/login").permitAll().
                and().logout().permitAll().invalidateHttpSession(true).
                deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler()).
                and().exceptionHandling().accessDeniedHandler(accessDeniedHandler()).
                and().sessionManagement().maximumSessions(10).expiredUrl("/login")

        ;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //密码加密
        return new BCryptPasswordEncoder(4);
    }
    @Bean
    public  AccessDeniedHandler accessDeniedHandler(){
       return new AccessDeniedHandler(){
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.getWriter().write(e.getMessage());
            }
        };
    }
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                User userDetails = (User) authentication.getPrincipal();
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
        return new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                try {
                    SecurityUser user = (SecurityUser) authentication.getPrincipal();
                    logger.info("USER : " + user.getUsername() + " LOGOUT SUCCESS !  ");
                } catch (Exception e) {
                    logger.info("LOGOUT EXCEPTION , e : " + e.getMessage());
                }
                httpServletResponse.sendRedirect("/view/login.html");
            }
        };
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {    //用户登录实现
        return new UserDetailsService() {
            @Autowired
            private UserRepository userDao;
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                User user = userDao.findByUsername(s);
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                if (user == null) {
                    throw new UsernameNotFoundException("Username " + s + " not found");
                }
                if("ADMIN".equals(user.getRole())){
                    return new org.springframework.security.core.userdetails.User(user.getUsername(),encoder.encode(user.getPassword()),AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
                }
                if("USER".equals(user.getRole())){
                    return new org.springframework.security.core.userdetails.User(user.getUsername(),encoder.encode(user.getPassword()),AuthorityUtils.createAuthorityList("ROLE_USER"));
                }
                return new org.springframework.security.core.userdetails.User(user.getUsername(),encoder.encode(user.getPassword()),AuthorityUtils.createAuthorityList("ROLE_a"));
            }
        };
    }
}
