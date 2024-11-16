package com.college.StudentProfileTracking.service;


import com.college.StudentProfileTracking.entity.Skill;
import com.college.StudentProfileTracking.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public void deleteSkill(String id) {
        skillRepository.deleteById(id);
    }
}
