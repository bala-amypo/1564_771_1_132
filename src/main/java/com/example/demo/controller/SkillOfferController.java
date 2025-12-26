package com.example.demo.controller;

import com.example.demo.model.SkillOffer;
import com.example.demo.service.SkillOfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/offers")
@SecurityRequirement(name = "bearerAuth")
public class SkillOfferController {

    private final SkillOfferService service;

    public SkillOfferController(SkillOfferService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SkillOffer> create(@RequestBody SkillOffer offer) {
        return ResponseEntity.ok(service.createOffer(offer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillOffer> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOfferById(id));
    }
}
