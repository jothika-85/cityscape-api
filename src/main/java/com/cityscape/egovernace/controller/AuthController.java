package com.cityscape.egovernace.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cityscape.egovernace.model.User; 
import com.cityscape.egovernace.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "\"https://cityscape-ui.vercel.app")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("CONTRACTOR"); 
        }
        return userRepository.save(user);
    }

   
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
           
            return foundUser; 
        }
        
        Map<String, String> error = new HashMap<>();
        error.put("message", "Invalid Username or Password");
        return error;
    }
}