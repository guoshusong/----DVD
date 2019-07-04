package com.summer.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.summer.demo.service.adminService;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class adminController {

    @Autowired
    adminService adminService;

    @PostMapping("/AdminLogin")
    public String adminLogin(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword, HttpSession session){
        if (adminService.login(adminName,adminPassword)){
            session.setAttribute("adminName",adminName);
            return "admin/index";
        }else {
            return "user/exeit";
        }
    }

    @PostMapping("/AdminRegister")
    public String adminRegister(@Param("adminName") String adminName,@Param("id") int id,@Param("adminPassword") String adminPassword){
        adminService.adminRegister(adminName,id,adminPassword);
        return "admin/login";
    }
}
