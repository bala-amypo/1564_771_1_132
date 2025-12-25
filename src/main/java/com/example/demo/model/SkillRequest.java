package com.example.barter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "skill_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "skill_category_id", nullable = false)
    private SkillCategory skillCategory;
    
    @Column(nullable = false)
    private String skillName;
    
    @Column(nullable = false)
    private String requiredLevel;
    
    @Column(nullable = false)
    private String status = "OPEN";
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
