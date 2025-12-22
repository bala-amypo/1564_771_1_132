package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.MatchRecord;
import com.example.demo.service.MatchmakingService;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Matches")
public class MatchRecordController {

    private final MatchmakingService service;

    public MatchRecordController(MatchmakingService service) {
        this.service = service;
    }

    @PostMapping("/generate/{userId}")
    public MatchRecord generateMatch(@PathVariable Long userId) {
        return service.generateMatch(userId);
    }

    @GetMapping("/{id}")
    public MatchRecord getMatchById(@PathVariable Long id) {
        return service.getMatchById(id);
    }

    @GetMapping("/user/{userId}")
    public List<MatchRecord> getMatchesForUser(@PathVariable Long userId) {
        return service.getMatchesForUser(userId);
    }

    @PutMapping("/{id}/status")
    public void updateMatchStatus(@PathVariable Long id, @RequestBody String status) {
        service.updateMatchStatus(id, status.trim().replace("\"", ""));
    }
}