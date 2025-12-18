package com.example.Barter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Barter.model.Skill;

@Service
public interface SkillService {
    SkillService createSkill(SkillService Skill);
    SkillService updateSkill(long id,Skill Skill);
    SkillService getSkillById(long id);
    List<SkillService> getAllSkills();
    SkillService deactivateSkill(long id);
}
