package com.summer.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("社会福利");
        message.setText("加我有福利");
        message.setTo("1160846013@qq.com");
        message.setFrom("2460526449@qq.com");
        mailSender.send(message);
    }

}
