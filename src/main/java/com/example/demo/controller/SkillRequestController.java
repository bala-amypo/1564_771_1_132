// // com/example/demo/controller/SkillRequestController.java
// package com.example.demo.controller;

// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.SkillRequest;
// import com.example.demo.service.SkillRequestService;

// import java.util.List;

// @RestController
// @RequestMapping("/api/skill-requests")
// @Tag(name = "Skill Requests")
// public class SkillRequestController {

//     private final SkillRequestService service;

//     public SkillRequestController(SkillRequestService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public SkillRequest createRequest(@RequestBody SkillRequest request) {
//         return service.createRequest(request);
//     }

//     @PutMapping("/{id}")
//     public SkillRequest updateRequest(@PathVariable Long id, @RequestBody SkillRequest request) {
//         return service.updateRequest(id, request);
//     }

//     @GetMapping("/{id}")
//     public SkillRequest getRequestById(@PathVariable Long id) {
//         return service.getRequestById(id);
//     }

//     @GetMapping("/user/{userId}")
//     public List<SkillRequest> getRequestsByUser(@PathVariable Long userId) {
//         return service.getRequestsByUser(userId);
//     }

//     @PutMapping("/{id}/deactivate")
//     public void deactivateRequest(@PathVariable Long id) {
//         service.deactivateRequest(id);
//     }
// }