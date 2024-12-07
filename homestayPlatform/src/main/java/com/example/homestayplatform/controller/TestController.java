package com.example.homestayplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.homestayplatform.repository.UserRepository;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/check")
    public ResponseEntity<String> checkConnection() {
        if (userRepository.count() > 0) {
            return ResponseEntity.ok("Connection to the database is successful!");
        } else {
            return ResponseEntity.ok("Connected, but no data found.");
        }
    }
}