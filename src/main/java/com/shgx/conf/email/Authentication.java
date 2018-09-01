package com.shgx.conf.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by gshan on 2018/9/1
 */
public class Authentication extends Authenticator {

    String username=null;
    String password=null;


    public Authentication(String username, String password) {
        this.username = username;
        this.password = password;
    }
    protected PasswordAuthentication getPasswordAuthentication(){
        PasswordAuthentication pa = new PasswordAuthentication(username, password);
        return pa;
    }
}
