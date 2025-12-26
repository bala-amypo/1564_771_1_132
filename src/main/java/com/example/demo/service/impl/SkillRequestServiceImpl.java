package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.service.SkillRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        return request;
    }

    @Override
    public SkillRequest getRequestById(Long id) {
        return new SkillRequest();
    }

    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return List.of();
    }
}
