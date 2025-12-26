package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SkillMatch;
import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.model.User;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MatchService;
import com.example.demo.util.SkillMatchingEngine;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    
    private final SkillMatchRepository matchRepository;
    private final SkillOfferRepository offerRepository;
    private final SkillRequestRepository requestRepository;
    private final UserRepository userRepository;
    private final SkillMatchingEngine matchingEngine;
    
    public MatchServiceImpl(SkillMatchRepository matchRepository,
                           SkillOfferRepository offerRepository,
                           SkillRequestRepository requestRepository,
                           UserRepository userRepository,
                           SkillMatchingEngine matchingEngine) {
        this.matchRepository = matchRepository;
        this.offerRepository = offerRepository;
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.matchingEngine = matchingEngine;
    }
    
    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillOffer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new BadRequestException("Offer not found"));
        
        SkillRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new BadRequestException("Request not found"));
        
        User admin = userRepository.findById(adminUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        if (offer.getUser().getId().equals(request.getUser().getId())) {
            throw new BadRequestException("Offer and request must be from different users");
        }
        
        SkillMatch match = new SkillMatch();
        match.setOffer(offer);
        match.setRequest(request);
        match.setMatchedBy(admin);
        match.setMatchScore(matchingEngine.calculateMatchScore(offer, request));
        
        try {
            return matchRepository.save(match);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Match not found");
        }
    }
    
    @Override
    public SkillMatch getMatch(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }
    
    @Override
    public List<SkillMatch> getAllMatches() {
        return matchRepository.findAll();
    }
    
    @Override
    public SkillMatch updateMatchStatus(Long matchId, String status) {
        SkillMatch match = getMatch(matchId);
        match.setMatchStatus(status);
        return matchRepository.save(match);
    }
    
    @Override
    public List<SkillMatch> getMatchesByOffer(Long offerId) {
        return matchRepository.findByOfferId(offerId);
    }
    
    @Override
    public List<SkillMatch> getMatchesByRequest(Long requestId) {
        return matchRepository.findByRequestId(requestId);
    }
}
