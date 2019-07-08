package com.example.demo.security;

import com.example.demo.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
/**
 * @author zfd
 * @date 2019/07/03
 */
public class SecurityUser extends User implements UserDetails {
    private static final long serialVersionUID=1L;
    public SecurityUser(User user){
        if(user!=null){
            this.setUsername(user.getUsername());
            this.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            this.setDriverInfoId(user.getDriverInfoId());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String username = this.getUsername();
        if (username != null) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(username);
            authorities.add(authority);
        }
        return authorities;
    }
    //账户是否过期，过期无法验证
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //指定用户是否解锁，锁定用户无法验证
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //指示密码是否已过期，过期不可认证
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //是否可用，禁用用户不能验证
    @Override
    public boolean isEnabled() {
        return true;
    }
}
