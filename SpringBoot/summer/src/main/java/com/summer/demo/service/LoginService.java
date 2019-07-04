package com.summer.demo.service;

import com.summer.demo.Demo.User;
import com.summer.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;

    User user;

    public boolean login(String userName,String userPassword){
        User user1 = userMapper.getUserByName(userName);
        if ((user1.getPassword()).equals(userPassword)){
            //登录成功，放行登录请求
            return true;
        }else {
            return false;
        }
    }

    public void Register(String userName,String Email,String userPassword){
        userMapper.insertUser(userName,Email,userPassword);
    }

    /**
     * 验证用户是否存在
     * @return
     */
    public boolean userExeit(String userName){
        if (userMapper.getUserByName(userName) == null){
            //用户不存在
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除用户
     * @param userName
     */
    public void userDelete(String userName){
        userMapper.deleteUser(userName);
    }
}
