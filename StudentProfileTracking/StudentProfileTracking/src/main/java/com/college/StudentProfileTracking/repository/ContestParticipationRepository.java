package com.college.StudentProfileTracking.repository;

import com.college.StudentProfileTracking.entity.ContestParticipation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ContestParticipationRepository extends MongoRepository<ContestParticipation, String> {

    List<ContestParticipation> findByStudentId(String studentId);

    int countByStudentId(String studentId);  // To count the number of contests a student participated in
}
