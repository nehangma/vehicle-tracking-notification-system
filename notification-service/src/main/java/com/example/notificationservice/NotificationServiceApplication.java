package com.example.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.notificationservice.dto.NotificationDTO;
import com.example.notificationservice.service.EmailService;

@EnableConfigurationProperties
@SpringBootApplication
public class NotificationServiceApplication implements CommandLineRunner{
    @Autowired
    private EmailService emailService;  // Autowire the EmailService

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // Creating a dummy notification to test email sending
        NotificationDTO notif=new NotificationDTO("wangyalsam@gmail.com","idiot I am sending this from laptop");
       

        // Sending the email through the EmailService
        emailService.sendEmail(notif);
    }
}