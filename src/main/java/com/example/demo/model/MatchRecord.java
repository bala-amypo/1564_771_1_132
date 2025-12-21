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
    @JoinColumn(name = "offer_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SkillOffer skillOffer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SkillRequest skillRequest;

    private String status; // PENDING, ACCEPTED, REJECTED

    public MatchRecord() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public SkillOffer getSkillOffer() { return skillOffer; }
    public void setSkillOffer(SkillOffer skillOffer) { this.skillOffer = skillOffer; }
    public SkillRequest getSkillRequest() { return skillRequest; }
    public void setSkillRequest(SkillRequest skillRequest) { this.skillRequest = skillRequest; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}