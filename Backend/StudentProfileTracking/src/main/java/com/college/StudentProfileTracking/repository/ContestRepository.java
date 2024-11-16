package com.college.StudentProfileTracking.repository;

import com.college.StudentProfileTracking.entity.Contest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContestRepository extends MongoRepository<Contest, String> {
    List<Contest> findAll(); // Fetch all contests
}
