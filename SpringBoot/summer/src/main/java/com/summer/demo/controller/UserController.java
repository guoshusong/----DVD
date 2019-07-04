package com.summer.demo.controller;


import com.summer.demo.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    LoginService loginService;

    /***
     *
     * @param userName
     * @param userPassword
     * @return
     */
    @PostMapping("/userLogin")
    public String userLogin(@Param("userName")String userName,@Param("userPassword") String userPassword,HttpSession session){
              if (loginService.login(userName,userPassword)){
                  session.setAttribute("userName",userName);
                  return "user/index";
              }else {
                  return "登录失败的界面";
              }
    }

    /***
     * 注册用户
     * @param userName
     * @param Email
     * @param userPassword
     * @return
     */
    @PostMapping("/userRegister")
    public String userRegister(@Param("userName")String userName,@Param("Email") String Email,@Param("userPassword") String userPassword){
        if (loginService.userExeit(userName)){
            loginService.Register(userName,Email,userPassword);
            return "/index";
        }else {
            //数据库中已存在该对象，返回存在该对象
            return "user/exeit";
        }

    }

    @PostMapping("/userDelete")
    public void userDelete(String userName){
        loginService.userDelete(userName);
    }
}
