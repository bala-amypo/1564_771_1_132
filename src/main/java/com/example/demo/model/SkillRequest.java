package com.example.demo.model;

public class SkillRequest {
    private Long id;
    private String urgencyLevel;
    private boolean active = true;
    private Skill skill;
    private UserProfile user;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }

    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }
}
