package com.cityscape.egovernace.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cityscape.egovernace.model.User; 
import com.cityscape.egovernace.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // 1. Register Logic (Contractor KYC flow)
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Contractors registration page vazhiya varathaala role-ah kandaipa set pannanum
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("CONTRACTOR"); 
        }
        return userRepository.save(user);
    }

    // 2. Login Logic (For both Official and Contractor)
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            // Success: Full user object (including role, companyName, etc.) return aagum
            return foundUser; 
        }
        
        Map<String, String> error = new HashMap<>();
        error.put("message", "Invalid Username or Password");
        return error;
    }
}