package com.college.StudentProfileTracking.repository;

import com.college.StudentProfileTracking.entity.SkillProgress;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SkillProgressRepository extends MongoRepository<SkillProgress, String> {

    List<SkillProgress> findByStudentId(String studentId);  // Get all skills for a student
}
