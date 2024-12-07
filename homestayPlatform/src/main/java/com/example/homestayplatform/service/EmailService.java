package com.example.homestayplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendBookingConfirmationEmail(String toEmail, String userName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-email@gmail.com"); // Replace with your email
        message.setTo(toEmail);
        message.setSubject("Booking Confirmation");
        message.setText("Dear " + userName + ",\n\nYour booking has been confirmed.\n\nThank you for choosing our service!");

        mailSender.send(message);
    }
}

