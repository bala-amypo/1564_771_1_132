package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category", description = "Skill category endpoints")
@CrossOrigin(origins = "*")
public class SkillCategoryController {
    
    private final SkillCategoryService categoryService;
    
    public SkillCategoryController(SkillCategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }
    
    @GetMapping
    public ResponseEntity<List<SkillCategory>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillCategory> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
}