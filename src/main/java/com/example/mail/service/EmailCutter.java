package com.example.mail.service;

import com.example.mail.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailCutter {
    @Autowired
    EmailCutter emailCutter;

    public String cut(User user) {
        int usrNameLength = user.getEmail().indexOf('@');
        char[] usrCharName = new char[usrNameLength];
        user.getEmail().getChars(0, usrNameLength, usrCharName, 0);
        String usrName = new String(usrCharName);
        return usrName;
    }

    ;
}
