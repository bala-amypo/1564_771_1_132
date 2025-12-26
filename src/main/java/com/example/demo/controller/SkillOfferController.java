package com.example.demo.controller;

import com.example.demo.model.SkillOffer;
import com.example.demo.service.SkillOfferService;
import org.springframework.http.ResponseEntity;

public class SkillOfferController {

    private final SkillOfferService service;

    public SkillOfferController(SkillOfferService service) {
        this.service = service;
    }

    public ResponseEntity<SkillOffer> create(SkillOffer offer) {
        return ResponseEntity.ok(service.createOffer(offer));
    }

    public ResponseEntity<SkillOffer> get(Long id) {
        return ResponseEntity.ok(service.getOfferById(id));
    }
}
