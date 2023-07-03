package com.ses.springmail.controller;

import com.ses.springmail.constance.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleEmailExampleController {
    @Autowired
    public JavaMailSender mailSender;

    @ResponseBody
    @GetMapping("/sendSimpleEmail")
    public String sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Mail");
        message.setText("Có ai ở đấy không");

        this.mailSender.send(message);

        return "Email Sent!";
    }
}
