package com.example.homestayplatform.service;

import com.example.homestayplatform.model.User;
import com.example.homestayplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // Find a user by their username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Register a new user
    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }
        return userRepository.save(user);
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> userValidate(String username, String password) {
        // Fetch the user by username
        Optional<User> user = userRepository.findByUsername(username);
        
        // Check if user exists and the password matches
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user; // Return the found user wrapped in Optional
        } else {
            return Optional.empty(); // Return an empty Optional if validation fails
        }
    }


    
    public boolean signupUser(String username, String password, String role, String email) {
        // Check if the username already exists
        if (userRepository.existsByUsername(username)) {
            return false; // Username already taken
        }

        // Create a new user and save it
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // You should hash the password before saving it
        newUser.setRole(role);
        newUser.setEmail(email);

        userRepository.save(newUser); // Save user to database
        return true;
}
}
