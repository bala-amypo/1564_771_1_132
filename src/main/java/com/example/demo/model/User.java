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
    public UserProfile getUserA() {
        return userA;
    }
    public UserProfile getUserB() {
        return userB;
    }
    public Skill getSkillOfferByA() {
        return skillOfferByA;
    }
    public Skill getSkillOfferByB() {
        return skillOfferByB;
    }
    public Timestamp getMatchedAt() {
        return matchedAt;
    }
    public String getRules() {
        return rules;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setUserA(UserProfile userA) {
        this.userA = userA;
    }
    public void setUserB(UserProfile userB) {
        this.userB = userB;
    }
    public void setSkillOfferByA(Skill skillOfferByA) {
        this.skillOfferByA = skillOfferByA;
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