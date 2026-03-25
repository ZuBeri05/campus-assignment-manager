package com.zuberi.cam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class MailService {
    private final SystemSettingService settings;

    public void send(String to, String subject, String text) {
        String enabled = settings.get("smtp.enabled").orElse("false");
        if (!Boolean.parseBoolean(enabled)) {
            throw new RuntimeException("SMTP disabled");
        }
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(settings.get("smtp.host").orElse(""));
        sender.setPort(Integer.parseInt(settings.get("smtp.port").orElse("587")));
        sender.setUsername(settings.get("smtp.username").orElse(""));
        sender.setPassword(settings.get("smtp.password").orElse(""));

        Properties props = sender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", settings.get("smtp.tls").orElse("true"));
        props.put("mail.smtp.ssl.enable", settings.get("smtp.ssl").orElse("false"));

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        sender.send(message);
    }
}
