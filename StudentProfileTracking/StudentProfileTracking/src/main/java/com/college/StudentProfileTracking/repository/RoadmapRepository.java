package com.college.StudentProfileTracking.repository;

import com.college.StudentProfileTracking.entity.Roadmap;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoadmapRepository extends MongoRepository<Roadmap, String> {
    List<Roadmap> findBySkillsContaining(String skillId);
}
