package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zfd
 */
@Controller
public class LoginController {
    @Autowired
    public UserDetailsService userDetailsService;
    @RequestMapping("/login")
    public String login(){
        return "forward:/view/login.html";
    }
}

