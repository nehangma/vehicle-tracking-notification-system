package com.example.notificationservice.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.notificationservice.dto.NotificationDTO;

@Service
@ConfigurationProperties(prefix = "email") 
public class EmailService {
	
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private String from;
    
    @Autowired
    private JavaMailSender mailSender;
    

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    

    public void sendEmail(NotificationDTO notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notification.getEmail());
        message.setSubject("Notification From Nehangma");
        message.setText(notification.getMessage());
        message.setFrom(from);
        
        logger.info("From: "+from);

        try {
            mailSender.send(message);

        }catch (Exception e) {
            // Log the error if email couldn't be sent
            System.err.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
