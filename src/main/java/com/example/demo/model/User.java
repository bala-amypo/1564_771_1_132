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
    public long getId() {
        return id;
    }
    public String fullName() {
        return fullName;
    }
    public String email() {
        return email;
    }
    public String password() {
        return password;
    }
    public String role() {
        return role;
    }
    public LocalDateTime createdAt() {
        return createdAt;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public void setfullName(String fullName) {
        this.fullName=fullName;
    }
    public void setemail(String email ) {
        this.email=email;
    }
    public void setpassword(String password) {
        this.password=password;
    }
    public void serrole(String role) {
        this.role = role;
    }
    public void setcreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    
    
}


