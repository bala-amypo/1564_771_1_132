// src/main/java/com/example/demo/controller/UserProfileController.java
package com.example.demo.repository;
package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Profiles", description = "Manage user profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfile> createUser(@RequestBody UserProfile user) {
        return ResponseEntity.ok(userProfileService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUser(@PathVariable Long id, @RequestBody UserProfile user) {
        return ResponseEntity.ok(userProfileService.updateUser(id, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userProfileService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        return ResponseEntity.ok(userProfileService.getAllUsers());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateUser(@PathVariable Long id) {
        userProfileService.deactivateUser(id);
        return ResponseEntity.ok().build();
    }
}