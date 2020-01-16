package com.example.mail.service;

import com.example.mail.domain.Mail;
import com.example.mail.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


@Service
public class MailReader {
    @Autowired
    private Mail mail;
    @Autowired
    private EmailCutter emailCutter;

    public void readMail(User user, Model model) throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(properties);
        Store store = null;
        try {

            store = session.getStore("imap");
            store.connect("imap.yandex.ru", 993, emailCutter.cut(user), user.getPassword());

            Folder inbox = null;
            try {
                inbox = store.getFolder("INBOX");
                inbox.open(Folder.READ_ONLY);

                int count = inbox.getMessageCount();

                Message[] messages = inbox.getMessages(1, count);

                ArrayList<Mail> mails = new ArrayList<>();
                Integer i = 0;
                for (Message message : messages) {
                    mail = new Mail();
                    mail.setFrom(((InternetAddress) message.getFrom()[0]).getAddress());
                    mail.setSubject(message.getSubject());
                    mail.setText(message.getContent().toString());
                    ++i;
                    mail.setId(i);//
                    mails.add(mail);

                }
                model.addAttribute("mails", mails);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inbox != null) {
                    inbox.close(false);
                }
            }

        } finally {
            if (store != null) {
                store.close();

            }
        }
    }
}

