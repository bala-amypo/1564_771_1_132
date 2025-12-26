package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.service.SkillOfferService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        return offer;
    }

    @Override
    public SkillOffer getOfferById(Long id) {
        return new SkillOffer();
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return List.of();
    }
}
