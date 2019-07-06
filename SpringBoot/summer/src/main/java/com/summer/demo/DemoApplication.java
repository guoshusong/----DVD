package com.summer.demo;

/***
 *登录 登录进入user下的index页面。
 * 注册 注册时检测该用户名是否已经存在。如果用户存在，进入user下的exeit页面提示该用户名已经存在。
 *管理员、用户注册登录均已实现
 * 准备实现拦截器
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAsync
@EnableScheduling
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
