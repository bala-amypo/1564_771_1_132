package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {

    private final SkillOfferRepository skillOfferRepository;

    public SkillOfferServiceImpl(SkillOfferRepository skillOfferRepository) {
        this.skillOfferRepository = skillOfferRepository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        if (offer == null) {
            throw new RuntimeException("Offer not found");
        }
        
        // Validation: skillName >= 5
        if (offer.getSkillName() == null || offer.getSkillName().length() < 5) {
            throw new RuntimeException("Skill name must be at least 5 characters");
        }

        // Validation: description optional but if provided >= 10
        if (offer.getDescription() != null && !offer.getDescription().isEmpty() && offer.getDescription().length() < 10) {
            throw new RuntimeException("Description must be at least 10 characters");
        }

        return skillOfferRepository.save(offer);
    }

    @Override
    public SkillOffer getOffer(Long id) {
        return skillOfferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return skillOfferRepository.findByUserId(userId);
    }

    @Override
    public List<SkillOffer> getOffersByCategory(Long categoryId) {
        return skillOfferRepository.findBySkillCategoryId(categoryId);
    }

    @Override
    public List<SkillOffer> getAvailableOffers() {
        return skillOfferRepository.findByAvailability("AVAILABLE");
    }
}