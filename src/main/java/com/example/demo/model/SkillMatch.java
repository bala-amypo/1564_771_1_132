package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "skill_matches")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = false)
    private SkillOffer offer;
    
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private SkillRequest request;
    
    @ManyToOne
    @JoinColumn(name = "matched_by_user_id", nullable = false)
    private User matchedBy;
    
    @Column(nullable = false)
    private String matchStatus = "PENDING";
    
    @Column(nullable = false)
    private Double matchScore = 0.0;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
