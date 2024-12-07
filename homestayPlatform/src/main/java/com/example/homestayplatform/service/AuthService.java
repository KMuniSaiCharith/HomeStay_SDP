package com.example.homestayplatform.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    // Logic to validate the user's credentials, e.g., by checking in the database
    public boolean validateUser(String username, String password) {
        // Implement your authentication logic here (e.g., check username and password)
        // For demonstration, we assume the credentials are valid.
        return "user".equals(username) && "password".equals(password);
    }
}