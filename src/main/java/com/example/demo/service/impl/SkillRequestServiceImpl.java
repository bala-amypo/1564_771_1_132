package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;

import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository repository;

    public SkillRequestServiceImpl(SkillRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        request.setActive(true);
        return repository.save(request);
    }

    @Override
    public SkillRequest updateRequest(Long id, SkillRequest updatedRequest) {
        SkillRequest request = getRequestById(id);
        request.setUrgencyLevel(updatedRequest.getUrgencyLevel());
        return repository.save(request);
    }

    @Override
    public SkillRequest getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found with id: " + id));
    }

    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return repository.findByUser_Id(userId);
    }

    @Override
    public void deactivateRequest(Long id) {
        SkillRequest request = getRequestById(id);
        request.setActive(false);
        repository.save(request);
    }
}
