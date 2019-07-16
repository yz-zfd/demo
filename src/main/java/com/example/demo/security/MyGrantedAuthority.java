package com.example.demo.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author zfd
 * 对用户的角色进行装饰，复写equals（）方法与hashcode（）方法
 * 使其能与过滤器中的某个url对应的角色相比较
 */
public class MyGrantedAuthority implements GrantedAuthority {
    private final String role;
    public MyGrantedAuthority(String role){
        this.role=role;
    }
    @Override
    public String getAuthority() {
        return role;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if (obj instanceof MyGrantedAuthority){
            return role.equals(((MyGrantedAuthority) obj).role);
        }
        if (obj instanceof MyConfigAttribute){
            return role.equals(((MyConfigAttribute) obj).getAttribute());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return role.hashCode();
    }
}
