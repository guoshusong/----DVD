package com.summer.demo.service;


import com.summer.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.summer.demo.Demo.admin;

@Service
public class adminService {

    @Autowired
    AdminMapper adminMapper;



    public boolean login(String adminName,String adminPassword){
         admin admin01 = adminMapper.getAdminByName(adminName);
        if ((admin01.getAdminPassword()).equals(adminPassword)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 将管理员星系插入数据库
     * @param adminName
     * @param id
     * @param adminPassword
     */
    public void adminRegister(String adminName,int id,String adminPassword){
        adminMapper.insertAdmin(adminName,id,adminPassword);
    }
}
