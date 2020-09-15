package com.atguigu.gulimall.ssoserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @PostMapping(value = "/doLogin")
    public String doLogin() {

        //登录成功跳转，跳回到登录页

        return null;
    }
    @GetMapping(value = "/login.html")
    public String loginPage() {

        //登录成功跳转，跳回到登录页

        return "login";
    }
}
