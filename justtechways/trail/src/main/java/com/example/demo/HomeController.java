package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	
	
    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "index"; // Renders home.html
    }
    

    @GetMapping("/services")
    public String services() {
        return "servicepage"; // Renders services.html
    }
    
    
    
  @GetMapping("/faq")
  public String faq() {
      return "faq";
  }
    
    
    @GetMapping("/career")
    public String career() {
    	return "career";
    }
    
    @GetMapping("/contact")
    public String showForm() {
        return "contactform"; // Renders contactform.html
    }
    
    @PostMapping("/send")
    public ModelAndView submitForm(@RequestParam("name") String name,
                                   @RequestParam("email") String email,
                                   @RequestParam("subject") String subject,
                                   @RequestParam("message") String message) {
        ContactForm contactForm = new ContactForm(name, email, subject, message);
        emailService.sendEmail(contactForm);
        return new ModelAndView("thankyoupage");
    }
}
