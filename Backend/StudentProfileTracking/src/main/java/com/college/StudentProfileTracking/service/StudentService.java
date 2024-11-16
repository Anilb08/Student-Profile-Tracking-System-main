package com.college.StudentProfileTracking.service;

import com.college.StudentProfileTracking.dto.SkillProgressDTO;
import com.college.StudentProfileTracking.entity.SkillProgress;
import com.college.StudentProfileTracking.entity.Student;
import com.college.StudentProfileTracking.repository.StudentRepository;
import com.college.StudentProfileTracking.repository.SkillProgressRepository; // Ensure you import this
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SkillProgressRepository skillProgressRepository; // Add SkillProgressRepository here

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Password encoder

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Create a new student
    public Student saveStudent(Student student) {
        // Encode the password before saving
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    // Find a student by username
    public Optional<Student> findStudentByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

    // Validate student credentials
    public boolean validateStudentCredentials(String username, String password) {
        Optional<Student> optionalStudent = findStudentByUsername(username);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return passwordEncoder.matches(password, student.getPassword());
        }
        return false; // Username not found
    }

    // Update a student
    public Student updateStudent(ObjectId id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existingStudent.setUsername(student.getUsername());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setSkillLevel(student.getSkillLevel());

        return studentRepository.save(existingStudent);
    }

    // Delete a student
    public void deleteStudent(ObjectId id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    // Assign skills to a student
    public Student assignSkillsToStudent(String studentId, List<String> skillIds) {
        Student student = studentRepository.findById(new ObjectId(studentId))
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setSkillIds(skillIds);
        return studentRepository.save(student);
    }

    // Assign ranking to a student
    public Student assignRankingToStudent(String studentId, String rankingId) {
        Student student = studentRepository.findById(new ObjectId(studentId))
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setRankingId(rankingId);
        return studentRepository.save(student);
    }

    // Get skill progress (convert from entity to DTO)
    public List<SkillProgressDTO> getSkillProgress(String studentId) {
        Student student = studentRepository.findById(new ObjectId(studentId))
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Convert List<SkillProgress> to List<SkillProgressDTO>
        return student.getSkillProgress().stream()
                .map(skillProgress -> new SkillProgressDTO(
                        skillProgress.getSkillId(),
                        skillProgress.getProgressPercentage(),
                        skillProgress.getProgressLevel() // Ensure to include the progress level
                ))
                .collect(Collectors.toList());
    }

    // Update skill progress
    public Student updateSkillProgress(String studentId, List<SkillProgressDTO> skillProgressDTOList) {
        Student student = studentRepository.findById(new ObjectId(studentId))
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Convert List<SkillProgressDTO> to List<SkillProgress>
        List<SkillProgress> skillProgressList = skillProgressDTOList.stream()
                .map(dto -> new SkillProgress(dto.getSkillId(), dto.getProgressPercentage(), dto.getProgressLevel())) // Use all constructor arguments
                .collect(Collectors.toList());

        student.setSkillProgress(skillProgressList);
        return studentRepository.save(student);
    }

    // Calculate skill level score
    private double calculateSkillLevelScore(String studentId) {
        return skillProgressRepository
                .findByStudentId(studentId)
                .stream()
                .mapToInt(SkillProgress::getProgressLevel) // Assuming progress level is what you want to average
                .average()
                .orElse(0);  // If no skills found, default to 0
    }

    // Find by username if needed
    public Student findByUsername(String username) {
        return findStudentByUsername(username).orElse(null);
    }
}
