package com.example.barter.controller;

import com.example.barter.model.SkillMatch;
import com.example.barter.service.MatchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Match", description = "Skill match endpoints")
@CrossOrigin(origins = "*")
public class MatchRecordController {
    
    private final MatchService matchService;
    
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SkillMatch> createMatch(
            @RequestParam Long offerId,
            @RequestParam Long requestId,
            @RequestParam Long adminUserId) {
        return ResponseEntity.ok(matchService.createMatch(offerId, requestId, adminUserId));
    }
    
    @GetMapping
    public ResponseEntity<List<SkillMatch>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillMatch> getMatch(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatch(id));
    }
    
    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SkillMatch> updateMatchStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(matchService.updateMatchStatus(id, status));
    }
    
    @GetMapping("/offer/{offerId}")
    public ResponseEntity<List<SkillMatch>> getMatchesByOffer(@PathVariable Long offerId) {
        return ResponseEntity.ok(matchService.getMatchesByOffer(offerId));
    }
    
    @GetMapping("/request/{requestId}")
    public ResponseEntity<List<SkillMatch>> getMatchesByRequest(@PathVariable Long requestId) {
        return ResponseEntity.ok(matchService.getMatchesByRequest(requestId));
    }
}