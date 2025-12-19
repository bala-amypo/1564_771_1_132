package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;

import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {

    private final SkillOfferRepository repository;

    public SkillOfferServiceImpl(SkillOfferRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        offer.setActive(true);
        return repository.save(offer);
    }

    @Override
    public SkillOffer updateOffer(Long id, SkillOffer updatedOffer) {
        SkillOffer offer = getOfferById(id);
        offer.setExperienceLevel(updatedOffer.getExperienceLevel());
        offer.setAvailableHoursPerWeek(updatedOffer.getAvailableHoursPerWeek());
        return repository.save(offer);
    }

    @Override
    public SkillOffer getOfferById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found with id: " + id));
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return repository.findByUser_Id(userId);
    }

    @Override
    public void deactivateOffer(Long id) {
        SkillOffer offer = getOfferById(id);
        offer.setActive(false);
        repository.save(offer);
    }
}
