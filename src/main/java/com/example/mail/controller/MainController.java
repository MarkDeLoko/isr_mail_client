package com.example.mail.controller;

import com.example.mail.domain.User;
import com.example.mail.service.MailReader;
import com.example.mail.service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MailSender mailSender;
    @Autowired
    private MailReader mailReader;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user,
                       @RequestParam(required = false, defaultValue = "") String filter,
                       Model model) throws MessagingException {
        mailReader.readMail(user, model);
        return "main";
    }

    @GetMapping("/send")
    public String send() {
        return "send";
    }

    @RequestMapping("/sendMail")
    public String send(
            @AuthenticationPrincipal User user,
            @RequestParam String subject,
            @RequestParam String receiver,
            @RequestParam String text,
            Model model
    ) throws IOException, MessagingException {

        mailSender.sendmail(user, receiver, subject, text);
        model.addAttribute("message", "Отправлено!");
        return "send";
    }
}
