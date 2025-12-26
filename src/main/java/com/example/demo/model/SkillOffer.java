package com.example.demo.model;

public class SkillOffer {
    private Long id;
    private String experienceLevel;
    private boolean active = true;
    private Skill skill;
    private UserProfile user;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getExperienceLevel() { return experienceLevel; }
    public void setExperienceLevel(String experienceLevel) { this.experienceLevel = experienceLevel; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }

    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }
}
