package com.example.demo.security;

import com.example.demo.dao.AuthorityRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.ObjectPostProcessor;
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
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author zfd
 * 本类作为spring SecuritySecurity安全构件器，在此类中配置了多个安全配置器
 * 供构件器使用，如configure方法中的security.authorizeRequests()是对权限配置器进行配置。
 * onfigure方法中的formLogin()方法是对登录认证器进行配置
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
        /*security.csrf().disable();
        security.authorizeRequests().
                antMatchers("/css/**","/img/**","/js/**","/loginOfAngular").permitAll().
                antMatchers("/operateDriver").hasRole("admin").
                requestMatchers(CorsUtils::isPreFlightRequest).permitAll().
        anyRequest().authenticated().
                        and().
                        formLogin().loginProcessingUrl("/angularLogin").permitAll().*//*loginPage("/login").*//*
                        *//*successForwardUrl("/index").failureForwardUrl("/login").permitAll().*//*
                        successHandler(loginSuccessHandler()).permitAll().
                        and().logout().permitAll().invalidateHttpSession(true).
                        deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler()).
                        and().exceptionHandling().accessDeniedHandler(accessDeniedHandler()).
                        and().sessionManagement().maximumSessions(10).expiredUrl("/index");*/
        /*FilterSecurityInterceptor f=null;*/

                //自定义安全策略
                 /*security.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                     @Override
                     public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                         o.setSecurityMetadataSource(getSecurityMetadataSource());
                         o.setAccessDecisionManager(getAccessDecisionManager());
                         return o;
                     }
                 }).antMatchers("/css/**","/img/**","/js/**").permitAll().
                         anyRequest().authenticated().
                                 and().
                                 formLogin().loginPage("/login").
                                 successForwardUrl("/index").failureForwardUrl("/login").permitAll().
                                 and().logout().permitAll().invalidateHttpSession(true).
                                 deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler()).
                                 and().exceptionHandling().accessDeniedHandler(accessDeniedHandler()).
                                 and().sessionManagement().maximumSessions(10).expiredUrl("/login");*/
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
                httpServletResponse.setCharacterEncoding("utf-8");
                httpServletResponse.getWriter().write("权限不足");
            }
        };
    }

    /*@Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                User userDetails = (User) authentication.getPrincipal();
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }*/
    /************************************angular**************************************************/
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() { //angular登录成功后
        return new AuthenticationSuccessHandler(){
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authentication.getAuthorities());
                httpServletResponse.setCharacterEncoding("utf-8");
                httpServletResponse.getWriter().write(token.toString());
            }

        };
    }
    /*@Bean
    public onAuthenticationFilureHandler loginFailHandler() { //angular登录失败
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                User userDetails = (User) authentication.getPrincipal();
                response.setCharacterEncoding("utf-8");
                response.getWriter().write("false");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        };
    }*/
    /***********************************angular****************************************************/
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
            private UserRepository userRepository;
            @Autowired
            private AuthorityRepository authorityRepository;
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                User user = userRepository.findByUsername(s);
                if (user == null) {
                    throw new UsernameNotFoundException("Username " + s + " not found");
                }
                return new SecurityUser(user,getAuthoritys(user));
            }
            private List<String> getAuthoritys(User user){
                return authorityRepository.findRolesOfUserByUsername(user.getUsername());
            }
        };
    }
    //配置安全元数据源
    @Bean(initMethod = "init")
    public MyFilterInvocationSecurityMetadataSource getSecurityMetadataSource(){
        return new MyFilterInvocationSecurityMetadataSource();
    }
    //配置安全决策者
    @Bean
    public AccessDecisionManager getAccessDecisionManager(){
        return new MyAccessDecisionManager(Arrays.asList(new MyAccessDecisionVoter()));
    }
}
