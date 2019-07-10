package com.example.demo.security;

import com.example.demo.service.MyAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MyAuthorityService myAuthorityService;

    private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> listLinkedHashMap;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
    private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> loadRequestMatcherConfigAttributes(){
        myAuthorityService.getAllUrlRoleMapper();
        return null;
    }
}
