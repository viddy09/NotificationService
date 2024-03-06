package com.example.notificationservice.Services;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final SimpleMailMessage simpleMailMessage;
    private final JavaMailSender mailSender;
    public EmailService(SimpleMailMessage simpleMailMessage, JavaMailSender mailSender) {
        this.simpleMailMessage = simpleMailMessage;
        this.mailSender = mailSender;
    }

    public void sendMail(String to, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(simpleMailMessage.getFrom());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        try {
            mailSender.send(message);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
