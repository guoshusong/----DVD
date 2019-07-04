package com.summer.demo.mapper;

import com.summer.demo.Demo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    /***
     * 根据用户名查询用户
     * @param userName
     * @return 根据用户名查出的对象
     */
    @Select("SELECT * FROM user where userName=#{userName}")
     public User getUserByName(String userName);


    /***
     * 插入用户
     * @param
     */
    @Insert("INSERT INTO user(userName,Email,userPassword) VALUES(#{userName},#{Email},#{userPassword})")
    public void insertUser(String userName,String Email,String userPassword);


    /**
     * 删除用户+
     * @param username
     */
    @Delete("DELETE FROM user WHERE userName=#{userName}")
    public void deleteUser(String username);
}
