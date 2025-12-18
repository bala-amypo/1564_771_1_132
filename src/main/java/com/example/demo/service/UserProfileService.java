// Service interfaces
package com.example.demo.service;

import com.example.demo.model.UserProfile;
import java.util.List;

public interface UserProfileService {
    UserProfile createUser(UserProfile user);
    UserProfile updateUser(Long id, UserProfile user);
    UserProfile getUserById(Long id);
    List<UserProfile> getAllUsers();
    void deactivateUser(Long id);
}