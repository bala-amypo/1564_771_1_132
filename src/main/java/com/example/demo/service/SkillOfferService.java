package com.example.Barter.service;

import org.springframework.stereotype.Service;

import com.example.Barter.model.Skill;
import com.example.Barter.model.SkillOffer;

@Service
public interface SkillOfferService {
    SkillOfferService createOffer(SkillOffer offer);
    SkillOfferService updateOffer(long id,Skill skill);
    SkillOfferService getOfferById(long id);
    SkillOfferService getOfferByUser(long userId);
    SkillOfferService deactivateOffer(long id);
}
