package com.college.StudentProfileTracking.repository;

import com.college.StudentProfileTracking.entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, ObjectId> {
    Optional<Student> findByUsername(String username);
    Optional<Student> findByEmail(String email); // Optional method to find by email
    Optional<Student> findById(ObjectId studentId); // Using ObjectId for findById
}
