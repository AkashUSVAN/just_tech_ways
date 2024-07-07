package com.example.demo;



import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmail(ContactForm contactForm);
}
