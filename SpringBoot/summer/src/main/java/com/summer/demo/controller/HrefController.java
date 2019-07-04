package com.summer.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HrefController {

    //转发请求到用户注册界面
    @RequestMapping("/Register")
    public String Regis(){
        return "user/Register";
    }

    //转发请求到管理员注册界面
    @RequestMapping("/adminRegister")
    public String adminReg(){
        return "admin/Register";
    }

    //转发请求到管理员登录界面
    @RequestMapping("/adminLogin")
    public String adminLogin(){
        return "admin/login";
    }

    @RequestMapping("login")
    public String login(){
        return "user/Login";
    }


}

