package com.example.barter.repository;

import com.example.barter.model.SkillRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillRequestRepository extends JpaRepository<SkillRequest, Long> {
    List<SkillRequest> findByUserId(Long userId);
    List<SkillRequest> findBySkillCategoryId(Long categoryId);
    List<SkillRequest> findByStatus(String status);
}