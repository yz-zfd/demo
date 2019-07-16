package com.example.demo.security;

import com.example.demo.service.MyAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 过滤器元数据源
 * 主要用于服务器启动时从数据库中加载出
 * 全部的url权限生成以url为key,角色集合为value的链表集合
 * 后期比对数据来自于此
 * @author zfd
 */
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MyAuthorityService myAuthorityService;
    /**
     * 为每个url配置了哪些角色
     */
    private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> listLinkedHashMap;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation) o).getRequest();
        for (Map.Entry<RequestMatcher, List<ConfigAttribute>> entry:listLinkedHashMap.entrySet()) {
            if(entry.getKey().matches(request)){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
    public void init(){
        listLinkedHashMap=loadRequestMatcherConfigAttributes();
    }

    /**
     * 加载全部路径的全部权限
     * @return
     */
    private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> loadRequestMatcherConfigAttributes(){
        LinkedHashMap<String, List<String>> allUrlRoleMapper = myAuthorityService.getAllUrlRoleMapper();
        LinkedHashMap<RequestMatcher,List<ConfigAttribute>> listLinkedHashMap=new LinkedHashMap<>(allUrlRoleMapper.size());
        for (Map.Entry<String,List<String>> entry:allUrlRoleMapper.entrySet()) {
            listLinkedHashMap.put(new AntPathRequestMatcher(entry.getKey()),getRoleConfigAttribute(entry.getValue()));
        }
        return listLinkedHashMap;
    }

    /**
     * 将角色封装成为ConfigAttribute
     * @param roles
     * @return
     */
    private List<ConfigAttribute> getRoleConfigAttribute(List<String> roles){
        List<ConfigAttribute> attributes=new ArrayList<>(roles.size());
        for (String role:roles) {
            attributes.add(new MyConfigAttribute(role));
        }
        return attributes;
    }

}
