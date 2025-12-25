package com.example.barter.service.impl;

import com.example.barter.exception.BadRequestException;
import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.SkillOffer;
import com.example.barter.repository.SkillOfferRepository;
import com.example.barter.repository.SkillCategoryRepository;
import com.example.barter.service.SkillOfferService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {
    
    private final SkillOfferRepository offerRepository;
    private final SkillCategoryRepository categoryRepository;
    
    public SkillOfferServiceImpl(SkillOfferRepository offerRepository, 
                                 SkillCategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        if (offer == null) {
            throw new ResourceNotFoundException("Offer not found");
        }
        if (offer.getSkillName() == null || offer.getSkillName().length() < 5) {
            throw new BadRequestException("Skill name must be at least 5 characters");
        }
        if (offer.getDescription() != null && offer.getDescription().length() < 10) {
            throw new BadRequestException("Description must be at least 10 characters");
        }
        return offerRepository.save(offer);
    }
    
    @Override
    public SkillOffer getOffer(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found"));
    }
    
    @Override
    public List<SkillOffer> getAllOffers() {
        return offerRepository.findAll();
    }
    
    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return offerRepository.findByUserId(userId);
    }
    
    @Override
    public List<SkillOffer> getOffersByCategory(Long categoryId) {
        return offerRepository.findBySkillCategoryId(categoryId);
    }
    
    @Override
    public List<SkillOffer> getAvailableOffers() {
        return offerRepository.findByAvailability("AVAILABLE");
    }
}