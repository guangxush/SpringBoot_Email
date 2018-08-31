package com.shgx.conf.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gshan on 2018/8/31
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailSenderTest {
    @Autowired
    private MailSender mailSender;

    @Test
    public void testSendEmail () {
        mailSender.sendEmail("666");
    }
}
