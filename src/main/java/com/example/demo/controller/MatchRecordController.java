package com.example.demo.controller;

import com.example.demo.model.MatchRecord;
import com.example.demo.service.MatchmakingService;
import org.springframework.http.ResponseEntity;

public class MatchRecordController {

    private final MatchmakingService service;

    public MatchRecordController(MatchmakingService service) {
        this.service = service;
    }

    public ResponseEntity<MatchRecord> generate(Long id) {
        return ResponseEntity.ok(service.generateMatch(id));
    }
}
