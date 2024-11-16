package com.college.StudentProfileTracking.controller;

import com.college.StudentProfileTracking.dto.LoginRequest;
import com.college.StudentProfileTracking.dto.RankingIdDTO;
import com.college.StudentProfileTracking.dto.SkillIdsDTO;
import com.college.StudentProfileTracking.dto.SkillProgressDTO; // Import DTO
import com.college.StudentProfileTracking.entity.Student;
import com.college.StudentProfileTracking.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Get a student by username
    @GetMapping("/username/{username}")
    public Optional<Student> getStudentByUsername(@PathVariable String username) {
        return studentService.findStudentByUsername(username);
    }

    // Update a student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable ObjectId id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable ObjectId id) {
        studentService.deleteStudent(id);
    }

    // Login a student
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        return "Login successful: " + authentication.getName();
    }

    // Assign skills to a student
    @PutMapping("/{studentId}/skills")
    public ResponseEntity<Student> assignSkillsToStudent(
            @PathVariable String studentId,
            @RequestBody SkillIdsDTO skillIdsDTO) {
        List<String> skillIds = skillIdsDTO.getSkillIds();
        Student updatedStudent = studentService.assignSkillsToStudent(studentId, skillIds);
        return ResponseEntity.ok(updatedStudent);
    }

    // Assign ranking to a student
    @PutMapping("/{studentId}/ranking")
    public ResponseEntity<Student> assignRanking(
            @PathVariable String studentId,
            @RequestBody RankingIdDTO rankingIdDTO) {
        String rankingId = rankingIdDTO.getRankingId();
        return ResponseEntity.ok(studentService.assignRankingToStudent(studentId, rankingId));
    }

    // **Get skill progress using DTO**
    @GetMapping("/{studentId}/progress")
    public ResponseEntity<List<SkillProgressDTO>> getSkillProgress(@PathVariable String studentId) {
        List<SkillProgressDTO> skillProgressDTO = studentService.getSkillProgress(studentId);
        return ResponseEntity.ok(skillProgressDTO);
    }

    // **Update skill progress using DTO**
    @PostMapping("/{studentId}/progress")
    public ResponseEntity<Student> updateSkillProgress(
            @PathVariable String studentId,
            @RequestBody List<SkillProgressDTO> skillProgressDTOList) {
        Student updatedStudent = studentService.updateSkillProgress(studentId, skillProgressDTOList);
        return ResponseEntity.ok(updatedStudent);
    }
}
