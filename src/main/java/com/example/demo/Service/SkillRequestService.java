package com.example.Barter.service;

import org.springframework.stereotype.Service;

import com.example.Barter.model.Skillrequest;

@Service
public interface SkillRequestService {
    SkillRequestService createRequest(Skillrequest request);
    SkillRequestService updateRequest(long id,Skillrequest request);
    SkillRequestService getRequestById(long id);
    SkillRequestService getRequestByUser(long userId);
    SkillRequestService deactivateRequest(long id);

}
