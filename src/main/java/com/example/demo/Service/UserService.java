package com.example.Barter.service;

import org.springframework.stereotype.Service;

import com.example.Barter.model.User;

@Service
public interface UserService {
    UserService register(User user);
    UserService findByEmail(String email);
    
}
