// com/example/demo/controller/SkillOfferController.java
package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SkillOffer;
import com.example.demo.service.SkillOfferService;

import java.util.List;

@RestController
@RequestMapping("/api/skill-offers")
@Tag(name = "Skill Offers")
public class SkillOfferController {

    private final SkillOfferService service;

    public SkillOfferController(SkillOfferService service) {
        this.service = service;
    }

    @PostMapping
    public SkillOffer createOffer(@RequestBody SkillOffer offer) {
        return service.createOffer(offer);
    }

    @PutMapping("/{id}")
    public SkillOffer updateOffer(@PathVariable Long id, @RequestBody SkillOffer offer) {
        return service.updateOffer(id, offer);
    }

    @GetMapping("/{id}")
    public SkillOffer getOfferById(@PathVariable Long id) {
        return service.getOfferById(id);
    }

    @GetMapping("/user/{userId}")
    public List<SkillOffer> getOffersByUser(@PathVariable Long userId) {
        return service.getOffersByUser(userId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateOffer(@PathVariable Long id) {
        service.deactivateOffer(id);
    }
}