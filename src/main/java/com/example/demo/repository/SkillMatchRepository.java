package com.example.barter.repository;

import com.example.barter.model.SkillMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillMatchRepository extends JpaRepository<SkillMatch, Long> {
    List<SkillMatch> findByOfferId(Long offerId);
    List<SkillMatch> findByRequestId(Long requestId);
    List<SkillMatch> findByMatchStatus(String matchStatus);
}