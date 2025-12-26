package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requestDescription;

    public SkillRequest() {}

    public SkillRequest(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRequestDescription() { return requestDescription; }
    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }
}
