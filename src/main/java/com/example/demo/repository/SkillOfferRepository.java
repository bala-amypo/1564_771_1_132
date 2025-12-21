package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SkillOffer;

import java.util.List;

public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {
    List<SkillOffer> findByUser_Id(Long userId);
    List<SkillOffer> findBySkill_Id(Long skillId);
}
