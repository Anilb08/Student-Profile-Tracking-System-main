package com.college.StudentProfileTracking.repository;

import com.college.StudentProfileTracking.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Method to find a user by their email
    User findByEmail(String email);

    // Method to check if a user exists by their email
    boolean existsByEmail(String email);
}
