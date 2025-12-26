package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String offerDescription;

    public SkillOffer() {}

    public SkillOffer(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOfferDescription() { return offerDescription; }
    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }
}
