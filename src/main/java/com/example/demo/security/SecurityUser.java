package com.example.demo.security;

import com.example.demo.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author zfd
 * 2019/07/03
 */
public class SecurityUser extends User implements UserDetails {
    private static final long serialVersionUID=1L;
    private  final List<String> authorities;
    public SecurityUser(User user,List<String> authorities){
        this.authorities=authorities;
        this.setUsername(user.getUsername());
        this.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        this.setDriverInfoId(user.getDriverInfoId());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authoritieList = new ArrayList<>();
        //遍历该用户所有可访问的url，将他们封装为GrantedAuthority
        for(String auth:authorities){
            authoritieList.add(new SimpleGrantedAuthority(auth));
        }

        return authoritieList;
    }
    /**
     *账户是否过期，过期无法验证
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
     *指定用户是否解锁，锁定用户无法验证
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *指示密码是否已过期，过期不可认证
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     *是否可用，禁用用户不能验证
     * @return boolean
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
