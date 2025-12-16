package com.example.Barter.model;

public class SkillOffer {
    private long id;
    private UserProfile user;
    private Skill skill;
    private String experienceLevel;
    private Integer availableHoursPerWeek;
    private boolean active;

    public SkillOffer(){

    }

    public SkillOffer(long id, UserProfile user, Skill skill, String experienceLevel, Integer availableHoursPerWeek,
            boolean active) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.experienceLevel = experienceLevel;
        this.availableHoursPerWeek = availableHoursPerWeek;
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

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public Integer getAvailableHoursPerWeek() {
        return availableHoursPerWeek;
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

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public void setAvailableHoursPerWeek(Integer availableHoursPerWeek) {
        this.availableHoursPerWeek = availableHoursPerWeek;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
