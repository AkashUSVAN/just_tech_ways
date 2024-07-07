package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendEmail(ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("gabrielep1991love@gmail.com"); // Replace with actual recipient email
        message.setSubject(contactForm.getSubject());
        message.setText("From: " + contactForm.getName() + "\nEmail: " + contactForm.getEmail() + "\n\n" + contactForm.getMessage());
        emailSender.send(message);
    }
}

