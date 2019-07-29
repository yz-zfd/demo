package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zfd
 */
@Controller
public class LoginController {
    /**
     *这里不是写的登录认证逻辑，而是返回给sercurity一个登录页面
     */
    @RequestMapping("/login")
    public String login(){
        return "forward:/view/login.html";
    }
    /**
     * 为了是angular实现跨源登录，需要自定义一个登录认证逻辑
     * 原因：每次当angular的登录页面请求过来时，springSercurity发现不是自己指定的登录
     * 页面的请求，就将自己指定的登录页面丢给angular。
     */
}

