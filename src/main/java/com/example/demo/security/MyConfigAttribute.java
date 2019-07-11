package com.example.demo.security;

import org.springframework.security.access.ConfigAttribute;

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
