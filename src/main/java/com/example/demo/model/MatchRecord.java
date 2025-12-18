package com.example.Barter.model;
@Entity
import java.security.Timestamp;

public class MatchRecord {
    private long id;
    private UserProfile userA;
    private UserProfile userB;
    private Skill skillOfferByA;
    private Skill skillOfferByB;
    private Timestamp matchedAt;
    private String rules;


    public MatchRecord(){

    }
    public MatchRecord(long id, UserProfile userA, UserProfile userB, Skill skillOfferByA, Skill skillOfferByB,
            Timestamp matchedAt, String rules) {
        this.id = id;
        this.userA = userA;
        this.userB = userB;
        this.skillOfferByA = skillOfferByA;
        this.skillOfferByB = skillOfferByB;
        this.matchedAt = matchedAt;
        this.rules = rules;
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
