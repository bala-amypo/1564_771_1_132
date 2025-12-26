package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    public ResponseEntity<Skill> update(Long id, Skill skill) {
        return ResponseEntity.ok(service.updateSkill(id, skill));
    }

    public ResponseEntity<List<Skill>> list() {
        return ResponseEntity.ok(service.getAllSkills());
    }
}
