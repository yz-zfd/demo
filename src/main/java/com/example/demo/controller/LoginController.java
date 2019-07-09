package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zfd
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        return "forward:/view/login.html";
    }
}

