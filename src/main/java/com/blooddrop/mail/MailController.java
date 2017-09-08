package com.blooddrop.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

@RestController
public class MailController {

    @Autowired
    EmailHtmlSender emailHtmlSender;

    @RequestMapping(value = "/send")
    public void send(){
        Context context = new Context();
//        context.setVariable("title", "Lorem Ipsum");
//        context.setVariable("description", "Lorem Lorem Lorem");
        EmailStatus emailStatus = emailHtmlSender.send("sebastian.kt7@gmail.com", "Title of email", "mail/send-notification", context);

    }
}
