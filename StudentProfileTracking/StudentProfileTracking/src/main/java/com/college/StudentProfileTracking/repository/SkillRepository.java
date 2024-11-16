package com.college.StudentProfileTracking.repository;

import com.college.StudentProfileTracking.entity.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends MongoRepository<Skill, String> {
    List<Skill> findByStudentId(String studentId); // Ensure the property exists in the Skill entity

    int countByStudentId(String studentId);
}
