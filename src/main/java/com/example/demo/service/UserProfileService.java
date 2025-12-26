package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface UserProfileService {
    UserProfile createUser(UserProfile user);
    UserProfile getUserById(Long id);
    void deactivateUser(Long id);
}

public interface SkillService {
    Skill updateSkill(Long id, Skill skill);
    List<Skill> getAllSkills();
}

public interface SkillOfferService {
    SkillOffer createOffer(SkillOffer offer);
    SkillOffer getOfferById(Long id);
    List<SkillOffer> getOffersByUser(Long userId);
}

public interface SkillRequestService {
    SkillRequest createRequest(SkillRequest request);
    SkillRequest getRequestById(Long id);
    List<SkillRequest> getRequestsByUser(Long userId);
}

public interface MatchmakingService {
    MatchRecord generateMatch(Long requestId);
    List<MatchRecord> getMatchesForUser(Long userId);
}

public interface UserService {}
