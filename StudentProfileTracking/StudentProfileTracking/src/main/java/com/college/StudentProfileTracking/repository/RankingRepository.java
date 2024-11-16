package com.college.StudentProfileTracking.repository;

import com.college.StudentProfileTracking.entity.Ranking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RankingRepository extends MongoRepository<Ranking, String> {
    Ranking findByStudentId(String studentId);

    // Custom method to retrieve all rankings sorted by totalScore in descending order with pagination
    Page<Ranking> findAllByOrderByTotalScoreDesc(Pageable pageable);
}
