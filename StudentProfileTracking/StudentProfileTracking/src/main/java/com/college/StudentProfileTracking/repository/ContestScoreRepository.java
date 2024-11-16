package com.college.StudentProfileTracking.repository;

import com.college.StudentProfileTracking.entity.ContestScore;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContestScoreRepository extends MongoRepository<ContestScore, String> {
    // Add custom query methods if needed
}
