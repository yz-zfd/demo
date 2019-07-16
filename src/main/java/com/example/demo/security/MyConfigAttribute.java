package com.example.demo.security;

import org.springframework.security.access.ConfigAttribute;
/**
 * 自定义的实现ConfigAttribute接口的类
 * 主要是对角色进行封装，复写equals（）方法与hashcode（）方法
 * 使得能与用户角色进行比较
 *
 */
public class MyConfigAttribute implements ConfigAttribute {
    private final String role;
    public  MyConfigAttribute(String role){
        this.role=role;
    }
    @Override
    public String getAttribute() {
        return role;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if (obj instanceof MyGrantedAuthority){
            return role.equals(((MyGrantedAuthority) obj).getAuthority());
        }
        if (obj instanceof MyConfigAttribute){
            return role.equals(((MyConfigAttribute) obj).role);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return role.hashCode();
    }

    @Override
    public String toString() {
        return "MyConfigAttribute{" +
                "role='" + role + '\'' +
                '}';
    }
}
