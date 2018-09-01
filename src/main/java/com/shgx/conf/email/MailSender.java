package com.shgx.conf.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * Created by gshan on 2018/8/31
 */
@Component
@PropertySource("classpath:config/email.properties")
public class MailSender {

    @Value("${mail.subject}")
    private String mailSubject;

    @Value("${mail.from}")
    private String mailFrom;

    @Value("${mail.password}")
    private String password;

    @Value("${mail.to}")
    private String mailTo;

    @Autowired
    private MailConfig mailConfig;

    public void sendEmail(String emailBody) {
        try{
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                    message.setSubject(mailSubject);
                    message.setFrom(mailFrom);
                    message.setTo(mailTo);
                    message.setText(emailBody);
                }
            };
            JavaMailSenderImpl javaMailSender = mailConfig.getMailSender();
            javaMailSender.send(preparator);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
