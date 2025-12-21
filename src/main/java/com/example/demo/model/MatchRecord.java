package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "skill_matches") // Updated table name per requirements
public class MatchRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_a_id", nullable = false)
    private UserProfile userA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_b_id", nullable = false)
    private UserProfile userB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_offered_by_a_id", nullable = false)
    private Skill skillOfferedByA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_offered_by_b_id", nullable = false)
    private Skill skillOfferedByB;

    private Timestamp matchedAt;

    @Column(nullable = false)
    private String status = "PENDING"; // Default status per requirements

    public MatchRecord() {}

    @PrePersist
    protected void onCreate() {
        this.matchedAt = new Timestamp(System.currentTimeMillis()); // Auto-populated per requirements
    }

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

    public Timestamp getMatchedAt() { return matchedAt; }
    public void setMatchedAt(Timestamp matchedAt) { this.matchedAt = matchedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}