package com.example.demo.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
import java.util.List;

/**
 * @author zfd
 */
public class MyAccessDecisionManager implements AccessDecisionManager {
    private List<AccessDecisionVoter<FilterInvocation>> accessDecisionVoters;

    public MyAccessDecisionManager(List<AccessDecisionVoter<FilterInvocation>> accessDecisionVoters){
        this.accessDecisionVoters=accessDecisionVoters;
    }

    /**
     * 核心决策判断，决策：如果有人投通过，则认为有权限
     * @param authentication
     * @param o
     * @param collection
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //未认证用户
        for (AccessDecisionVoter<FilterInvocation> accessDecisionVoter:accessDecisionVoters) {
            int result=accessDecisionVoter.vote(authentication,(FilterInvocation)o,collection);
            //这里用switch的原因是有三种结果，但是本决策为只要有人投反对票即为通过
            switch (result){
                case AccessDecisionVoter.ACCESS_GRANTED:
                    return;
                default:
                    break;
            }
        }
        throw new AccessDeniedException("user"+authentication.getName()+"的请求没有权限！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
