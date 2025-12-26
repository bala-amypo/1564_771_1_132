package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.http.ResponseEntity;

public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    public ResponseEntity<UserProfile> create(UserProfile user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    public ResponseEntity<UserProfile> get(Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    public ResponseEntity<Void> deactivate(Long id) {
        service.deactivateUser(id);
        return ResponseEntity.ok().build();
    }
}
