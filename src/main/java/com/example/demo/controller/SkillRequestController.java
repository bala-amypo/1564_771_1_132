package com.example.demo.controller;

import com.example.demo.model.SkillRequest;
import com.example.demo.service.SkillRequestService;
import org.springframework.http.ResponseEntity;

public class SkillRequestController {

    private final SkillRequestService service;

    public SkillRequestController(SkillRequestService service) {
        this.service = service;
    }

    public ResponseEntity<SkillRequest> create(SkillRequest req) {
        return ResponseEntity.ok(service.createRequest(req));
    }

    public ResponseEntity<SkillRequest> get(Long id) {
        return ResponseEntity.ok(service.getRequestById(id));
    }
}
