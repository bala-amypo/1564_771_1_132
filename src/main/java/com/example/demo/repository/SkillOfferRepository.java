package com.example.Barter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillOfferRepository  extends JpaRepository<SkillOfferRepository,String> {

    
}