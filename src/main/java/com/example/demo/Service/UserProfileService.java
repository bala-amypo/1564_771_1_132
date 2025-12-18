package com.example.Barter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Barter.model.UserProfile;

@Service
public interface UserProfileService {
        UserProfileService createUser(UserProfile User);
        UserProfileService updateUser(UserProfile User,long id);
        UserProfileService getById(long id);
        List<UserProfileService> getAllUsers();
        UserProfileService deactivateUser(long id);
    
} 
