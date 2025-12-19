// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.Skill;
// import com.example.demo.repository.SkillRepository;
// import com.example.demo.service.SkillService;

// import java.util.List;

// @Service
// public class SkillServiceImpl implements SkillService {

//     private final SkillRepository repository;

//     public SkillServiceImpl(SkillRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public Skill createSkill(Skill skill) {
//         skill.setActive(true);
//         return repository.save(skill);
//     }

//     @Override
//     public Skill updateSkill(Long id, Skill updatedSkill) {
//         Skill skill = getSkillById(id);
//         skill.setCategory(updatedSkill.getCategory());
//         skill.setDescription(updatedSkill.getDescription());
//         return repository.save(skill);
//     }

//     @Override
//     public Skill getSkillById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() ->
//                         new RuntimeException("Skill not found with id: " + id));
//     }

//     @Override
//     public List<Skill> getAllSkills() {
//         return repository.findAll();
//     }

//     @Override
//     public void deactivateSkill(Long id) {
//         Skill skill = getSkillById(id);
//         skill.setActive(false);
//         repository.save(skill);
//     }
// }
