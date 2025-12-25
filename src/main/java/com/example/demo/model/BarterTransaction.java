package com.example.barter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "barter_transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarterTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private SkillMatch match;
    
    @Column(nullable = false)
    private String status = "INITIATED";
    
    private String offererFeedback;
    
    private String requesterFeedback;
    
    private Integer offererRating;
    
    private Integer requesterRating;
    
    private LocalDateTime completedAt;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }