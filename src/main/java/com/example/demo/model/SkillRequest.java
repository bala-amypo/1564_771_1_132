package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "skill_requests")
public class SkillRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    // This ignores the Hibernate internal proxy fields that cause the 500 error
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UserProfile user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Skill skill;

    private String urgencyLevel; // Low, Medium, High

    @Column(nullable = false)
    private Boolean active = true;

    // Default Constructor
    public SkillRequest() {}

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public UserProfile getUser() { return user; }
    public void setUser(UserProfile user) { this.user = user; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public String getUrgencyLevel() { return urgencyLevel; }
    public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}