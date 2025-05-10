package com.example.notificationservice.controller;


import com.example.notificationservice.dto.NotificationDTO;
import com.example.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final EmailService emailService;

    @Autowired
    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody NotificationDTO request) {
        emailService.sendEmail(request);
        return ResponseEntity.ok("Email sent successfully to " + request.getEmail());
    }
}
