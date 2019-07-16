package com.example.demo.security;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
/**
 * 暂未使用
 * @author zfd
 * 本类实现了AccessDecisionVoter<FilterInvocation> 接口
 * 作用为是一个投票器。
 * 通过比对用户角色集合以及该用户请求的url的权限集合有无
 * 交集确定该用户是否有权限
 *
 */
public class MyAccessDecisionVoter implements AccessDecisionVoter<FilterInvocation> {
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }

    /**
     *
     * @param authentication 对登录后用户的封装(赋予了登录认证)
     * @param filterInvocation 过滤器类
     * @param collection 用户权限集合
     * @return
     */
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
