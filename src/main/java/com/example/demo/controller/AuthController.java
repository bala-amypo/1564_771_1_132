package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
   
    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("MONITOR");
        }

        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginRequest) {
      
        User user = userService.findByEmail(loginRequest.getEmail());
        return ResponseEntity.ok(user);
    }
}