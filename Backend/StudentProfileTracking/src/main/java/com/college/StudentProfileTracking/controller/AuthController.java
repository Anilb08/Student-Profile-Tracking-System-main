package com.college.StudentProfileTracking.controller;

import com.college.StudentProfileTracking.dto.SignupRequest;
import com.college.StudentProfileTracking.dto.AuthenticationRequest;
import com.college.StudentProfileTracking.dto.AuthenticationResponse;
import com.college.StudentProfileTracking.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        String token = authenticationService.authenticate(request.getEmail(), request.getPassword());
        return new ResponseEntity<>(new AuthenticationResponse(token), HttpStatus.OK);
    }

    // Signup Endpoint
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        authenticationService.registerUser(request); // Register user with additional fields
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
