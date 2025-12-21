package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "match_records")
public class MatchRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_a_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UserProfile userA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_b_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UserProfile userB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_a_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Skill skillOfferedByA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_b_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Skill skillOfferedByB;

    private String status; // PENDING, ACCEPTED, REJECTED

    public MatchRecord() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserProfile getUserA() { return userA; }
    public void setUserA(UserProfile userA) { this.userA = userA; }

    public UserProfile getUserB() { return userB; }
    public void setUserB(UserProfile userB) { this.userB = userB; }

    public Skill getSkillOfferedByA() { return skillOfferedByA; }
    public void setSkillOfferedByA(Skill skillOfferedByA) { this.skillOfferedByA = skillOfferedByA; }

    public Skill getSkillOfferedByB() { return skillOfferedByB; }
    public void setSkillOfferedByB(Skill skillOfferedByB) { this.skillOfferedByB = skillOfferedByB; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}