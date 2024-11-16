package com.college.StudentProfileTracking.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user from the database or other source based on the username
        // Example: Find the user from your database
        // Student student = studentRepository.findByUsername(username);
        // if (student == null) {
        //     throw new UsernameNotFoundException("User not found");
        // }
        // return new User(student.getUsername(), student.getPassword(), List.of());

        // Temporary placeholder logic for now
        throw new UsernameNotFoundException("User not found");
    }
}
