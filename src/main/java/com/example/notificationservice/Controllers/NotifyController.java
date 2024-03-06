package com.example.notificationservice.Controllers;

import com.example.notificationservice.Services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotifyController {
    public final EmailService emailService;
    public NotifyController(EmailService emailService) {
        this.emailService = emailService;
    }

    //Notify via Mail
    @KafkaListener(topics = "NotifyEmail")
    public ResponseEntity<String> notifyCustomer(String message){
        ResponseEntity<String> responseEntity;
        try{
            // System.out.println("Message Received : "+ message);
            // Deliver Message
            emailService.sendMail("some-email-address@gmail.com", "Order Status Update", message);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    //Notify via sms

    //Notify via whatsapp
}
