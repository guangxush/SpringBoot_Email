package com.shgx.conf.controller;

import com.shgx.conf.email.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gshan on 2018/8/31
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailSender mailSender;

    @RequestMapping(value = "/send/{emailbody}")//http://localhost:8080/mail/send?emailbody=hello
    public String send(@PathVariable String emailbody){
        mailSender.sendEmail(emailbody);
        return "send succeed!";
    }
}

