package com.shgx.conf.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * Created by gshan on 2018/8/31
 */
@Component
@PropertySource("classpath:config/email.properties")
public class MailConfig {

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private int  port;

    @Value("${server.port}")
    private int  server;

    @Value("${mail.protocol}")
    private String protocol;

    public JavaMailSenderImpl getMailSender () {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setProtocol(protocol);
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        return javaMailSender;
    }

}
