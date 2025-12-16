package com.example.Barter.model;

public class User{
    private long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public User(){

    }

    public User(long id,String fullName,String email,String password,String role,LocalDateTime createdAt){
        this.fullName=fullName;
        this.email=email;
        this.password=password;
        this.role=role;
        this.createdAt=createdAt;
    }
    
}