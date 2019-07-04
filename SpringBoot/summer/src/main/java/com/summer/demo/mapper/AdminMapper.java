package com.summer.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.summer.demo.Demo.admin;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM admin where adminName =#{adminName}")
    public admin getAdminByName(String adminName);


    @Insert("INSERT INTO admin(adminName,id,adminPassword) VALUES(#{adminName},#{id},#{adminPassword})")
    public void  insertAdmin(String adminName,Integer id,String adminPassword);
}
