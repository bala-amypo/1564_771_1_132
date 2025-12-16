package com.example.Barter.model;

import java.security.Timestamp;

public class UserProfile {
    private int id;
    private String name;
    private String email;
    private String bio;
    private Boolean Active;
    private Timestamp CreatedAt;
    private Timestamp updatedAt;

    public UserProfile(){

    }
    
    public UserProfile(int id, String name, String email, String bio, Boolean active, Timestamp createdAt,
            Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bio = bio;
        Active = active;
        CreatedAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public Boolean getActive() {
        return Active;
    }

    public Timestamp getCreatedAt() {
        return CreatedAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

    public void setCreatedAt(Timestamp createdAt) {
        CreatedAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
     
}
    
