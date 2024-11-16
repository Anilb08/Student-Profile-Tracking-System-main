package com.college.StudentProfileTracking.service;

import com.college.StudentProfileTracking.dto.AuthenticationRequest;
import com.college.StudentProfileTracking.entity.User;
import com.college.StudentProfileTracking.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void registerUser(AuthenticationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            logger.warn("Registration attempt failed: User already exists with email {}", request.getEmail());
            throw new RuntimeException("User already exists with this email"); // Custom exception can be used
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        logger.info("User registered successfully with email {}", request.getEmail());
    }
}
