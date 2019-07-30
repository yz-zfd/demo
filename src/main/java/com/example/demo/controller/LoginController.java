package com.example.demo.controller;

import com.example.demo.dao.AuthorityRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import com.example.demo.security.MyGrantedAuthority;
import com.example.demo.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zfd
 */
@Controller
public class LoginController {
    /**
     *这里不是写的登录认证逻辑，而是返回给sercurity一个登录页面
     */
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @RequestMapping("/login")
    public String login(){
        return "forward:/view/login.html";
    }
    /**
     * 为了是angular实现跨源登录，需要自定义一个登录认证逻辑
     * 原因：每次当angular的登录页面请求过来时，springSercurity发现不是自己指定的登录
     * 页面的请求，就将自己指定的登录页面丢给angular。
     */
    @RequestMapping(value = "/loginOfAngular",method = RequestMethod.POST)
    @ResponseBody
    public String loginOfAngular(String username,String password){

        User user = userRepository.findByUsername(username);
        if(user==null){
            System.out.println(username+password);
            return "false";
        }
        else {
            if(user.getPassword().equals(password)){
                List<String> list = authorityRepository.findRolesOfUserByUsername(username);
                SecurityUser securityUser=new SecurityUser(user,list);
                //这里存在隐患，如果系统中对认证后的角色进行操作可能会出问题
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password,securityUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(token);
                System.out.println("true");
                return "true";
            }

        }
        return "false";
    }
}

