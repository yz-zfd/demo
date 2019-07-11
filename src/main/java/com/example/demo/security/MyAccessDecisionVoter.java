package com.example.demo.security;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;

public class MyAccessDecisionVoter implements AccessDecisionVoter<FilterInvocation> {
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }

    @Override
    public int vote(Authentication authentication, FilterInvocation filterInvocation, Collection<ConfigAttribute> collection) {
        //如果包含admin权限直接放行
        if (authentication.getAuthorities().contains(new MyGrantedAuthority("admin"))){
            return ACCESS_GRANTED;
        }
        for (ConfigAttribute c:collection) {
            if (authentication.getAuthorities().contains(c)){
                return ACCESS_GRANTED;
            }
        }
        return ACCESS_ABSTAIN;
    }
}
