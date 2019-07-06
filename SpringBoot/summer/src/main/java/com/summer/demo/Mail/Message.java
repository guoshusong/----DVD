package com.summer.demo.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class Message {
    @Autowired
    JavaMailSenderImpl mailSender;

    public void sendMail(String from,String to,String subject,String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setText(text);
        message.setSubject(subject);
        try {
            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
