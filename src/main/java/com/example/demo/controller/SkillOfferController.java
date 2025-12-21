package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class SkillCategoryController {

    private final SkillCategoryRepository skillCategoryRepository;

    public SkillCategoryController(SkillCategoryRepository skillCategoryRepository) {
        this.skillCategoryRepository = skillCategoryRepository;
    }

    // POST / – Creates category (ADMIN only logic)
    @PostMapping("/")
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
        SkillCategory savedCategory = skillCategoryRepository.save(category);
        return ResponseEntity.ok(savedCategory);
    }

    // GET / – Lists all categories
    @GetMapping("/")
    public ResponseEntity<List<SkillCategory>> getAllCategories() {
        return ResponseEntity.ok(skillCategoryRepository.findAll());
    }

    // GET /{id} – Retrieves specific category
    @GetMapping("/{id}")
    public ResponseEntity<SkillCategory> getCategoryById(@PathVariable Long id) {
        return skillCategoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}