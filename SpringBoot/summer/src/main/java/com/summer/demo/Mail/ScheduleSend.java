package com.summer.demo.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleSend {


    @Autowired
    Message message;
    /**
     * 定时发送邮件 一分钟一次
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void Schsend(){
        message.sendMail("15176193717@163.com","2460526449@qq.com","SpringBoor定时任务开会","SpringBoor定时任务测试今晚开会");
    }
}
