package com.example.demo.model;

public class MatchRecord {
    private String status;
    private UserProfile userA;
    private UserProfile userB;
    private Skill skillOfferedByA;
    private Skill skillOfferedByB;

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public UserProfile getUserA() { return userA; }
    public void setUserA(UserProfile userA) { this.userA = userA; }

    public UserProfile getUserB() { return userB; }
    public void setUserB(UserProfile userB) { this.userB = userB; }

    public Skill getSkillOfferedByA() { return skillOfferedByA; }
    public void setSkillOfferedByA(Skill skillOfferedByA) { this.skillOfferedByA = skillOfferedByA; }

    public Skill getSkillOfferedByB() { return skillOfferedByB; }
    public void setSkillOfferedByB(Skill skillOfferedByB) { this.skillOfferedByB = skillOfferedByB; }
}
