package com.example.barter.service.impl;

import com.example.barter.exception.BadRequestException;
import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.SkillRequest;
import com.example.barter.repository.SkillRequestRepository;
import com.example.barter.repository.SkillCategoryRepository;
import com.example.barter.service.SkillRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {
    
    private final SkillRequestRepository requestRepository;
    private final SkillCategoryRepository categoryRepository;
    
    public SkillRequestServiceImpl(SkillRequestRepository requestRepository,
                                   SkillCategoryRepository categoryRepository) {
        this.requestRepository = requestRepository;
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    public SkillRequest createRequest(SkillRequest request) {
        if (request == null) {
            throw new ResourceNotFoundException("Request not found");
        }
        if (request.getSkillName() == null || request.getSkillName().length() < 5) {
            throw new BadRequestException("Skill name must be at least 5 characters");
        }
        return requestRepository.save(request);
    }
    
    @Override
    public SkillRequest getRequest(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
    }
    
    @Override
    public List<SkillRequest> getAllRequests() {
        return requestRepository.findAll();
    }
    
    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return requestRepository.findByUserId(userId);
    }
    
    @Override
    public List<SkillRequest> getRequestsByCategory(Long categoryId) {
        return requestRepository.findBySkillCategoryId(categoryId);
    }
    
    @Override
    public List<SkillRequest> getOpenRequests() {
        return requestRepository.findByStatus("OPEN");
    }
}
