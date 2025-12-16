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
    public void fullName(String fullName) {
        this.fullName=fullName;
    }
    public void email(String email ) {
        this.email=email;
    }
    public void password(String password) {
        this.pa;
    }
    public void setSkillOfferByB(Skill skillOfferByB) {
        this.skillOfferByB = skillOfferByB;
    }
    public void setMatchedAt(Timestamp matchedAt) {
        this.matchedAt = matchedAt;
    }
    public void setRules(String rules) {
        this.rules = rules;
    }
    
    
}


}