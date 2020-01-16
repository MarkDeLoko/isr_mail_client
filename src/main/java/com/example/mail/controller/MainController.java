package com.example.sweater.controller;

import com.example.sweater.domain.User;
import com.example.sweater.repos.MessageRepo;
import com.example.sweater.repos.UserRepo;
import com.example.sweater.service.MailSender;
import com.example.sweater.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MailSender mailSender;

    @Autowired
    private UserSevice userService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        // Iterable<Message> messages = messageRepo.findAll();

//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }
//
//        model.addAttribute("messages", messages);
//        model.addAttribute("filter", filter);

        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String main(
            @AuthenticationPrincipal User user,
            @RequestParam String subject,
            @RequestParam String receiver,
            @RequestParam String text

    ) throws AddressException, IOException, MessagingException {
        System.out.println("Done!!!");
        mailSender.sendmail(user.getEmail(), user.getPassword(), receiver, subject, text);
        return "main";
    }
}
