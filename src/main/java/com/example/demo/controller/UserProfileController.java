// com/example/demo/controller/UserProfileController.java
package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Profiles")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping
    public UserProfile createUser(@RequestBody UserProfile user) {
        return service.createUser(user);
    }

    @PutMapping("/{id}")
    public UserProfile updateUser(@PathVariable Long id, @RequestBody UserProfile user) {
        return service.updateUser(id, user);
    }

    @GetMapping("/{id}")
    public UserProfile getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<UserProfile> getAllUsers() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateUser(@PathVariable Long id) {
        service.deactivateUser(id);
    }
}