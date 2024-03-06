package com.example.notificationservice.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfig
{
    @Bean
    public SimpleMailMessage simpleMailMessage()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("prakashparmar.pp@gmail.com");
        return message;
    }
}
