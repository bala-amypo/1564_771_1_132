package com.example.Barter.model;
@Entity
public class Skillrequest {
    private long id;
    private UserProfile user;
    private Skill skill;
    private String urgencyLevel;
    private boolean active;

    public Skillrequest(){

    }
    public Skillrequest(long id, UserProfile user, Skill skill, String urgencyLevel, boolean active) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.urgencyLevel = urgencyLevel;
        this.active = active;
    }
    public long getId() {
        return id;
    }
    public UserProfile getUser() {
        return user;
    }
    public Skill getSkill() {
        return skill;
    }
    public String getUrgencyLevel() {
        return urgencyLevel;
    }
    public boolean isActive() {
        return active;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setUser(UserProfile user) {
        this.user = user;
    }
    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
