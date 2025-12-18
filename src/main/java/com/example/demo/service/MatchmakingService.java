package com.example.Barter.service;

import org.springframework.stereotype.Service;

@Service
public interface MatchmakingRequest {
    MatchmakingRequest generateMatch(long userId);
    MatchmakingRequest getMatchById(long id);
    MatchmakingRequest getMatchForUser(long userId);
    MatchmakingRequest updateMatchStatus(long id,String status);
}
