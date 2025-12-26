package com.example.demo.service.impl;

import com.example.demo.model.MatchRecord;
import com.example.demo.service.MatchmakingService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchmakingServiceImpl implements MatchmakingService {

    @Override
    public MatchRecord generateMatch(Long requestId) {
        return new MatchRecord();
    }

    @Override
    public List<MatchRecord> getMatchesForUser(Long userId) {
        return List.of();
    }
}
