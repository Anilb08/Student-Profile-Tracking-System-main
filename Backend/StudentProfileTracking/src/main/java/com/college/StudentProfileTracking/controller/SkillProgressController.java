package com.college.StudentProfileTracking.controller;

import com.college.StudentProfileTracking.dto.SkillProgressDTO;
import com.college.StudentProfileTracking.entity.SkillProgress;
import com.college.StudentProfileTracking.service.SkillProgressService;
import org.bson.types.ObjectId;  // Import for ObjectId
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/{studentId}/skillProgress")
@CrossOrigin(origins = "http://localhost:5173")
public class SkillProgressController {

    @Autowired
    private SkillProgressService skillProgressService;

    // GET: Retrieve skill progress for a student
    @GetMapping
    public ResponseEntity<List<SkillProgress>> getSkillProgress(@PathVariable String studentId) {
        List<SkillProgress> skillProgress = skillProgressService.getSkillProgressForStudent(studentId);
        if (skillProgress.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 No Content if no progress found
        }
        return ResponseEntity.ok(skillProgress);
    }

    // POST: Update skill progress for a student
    @PostMapping
    public ResponseEntity<String> addSkillProgress(
            @PathVariable String studentId,
            @RequestBody List<SkillProgressDTO> skillProgressList) {

        if (skillProgressList == null || skillProgressList.isEmpty()) {
            return ResponseEntity.badRequest().body("Skill progress list cannot be empty."); // Return 400 Bad Request
        }

        // Convert studentId to ObjectId
        ObjectId studentObjectId = new ObjectId(studentId);
        skillProgressService.updateSkillProgress(String.valueOf(studentObjectId), skillProgressList); // Pass the correct student ID
        return ResponseEntity.ok("Skill progress updated successfully.");
    }

    // DELETE: Remove a specific skill progress entry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkillProgress(
            @PathVariable String studentId,
            @PathVariable String id) {
        skillProgressService.deleteSkillProgress(studentId, id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
