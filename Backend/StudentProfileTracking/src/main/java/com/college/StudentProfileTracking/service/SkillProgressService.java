package com.college.StudentProfileTracking.service;

import com.college.StudentProfileTracking.dto.SkillProgressDTO;
import com.college.StudentProfileTracking.entity.SkillProgress;
import com.college.StudentProfileTracking.repository.SkillProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillProgressService {

    @Autowired
    private SkillProgressRepository skillProgressRepository;

    // Get skill progress for a specific student
    public List<SkillProgress> getSkillProgressForStudent(String studentId) {
        return skillProgressRepository.findByStudentId(studentId);
    }

    // Save or update skill progress
    public SkillProgress saveSkillProgress(String studentId, SkillProgress skillProgress) {
        skillProgress.setStudentId(studentId); // Ensure the studentId is set
        return skillProgressRepository.save(skillProgress);
    }

    // Update skill progress for a student
    public void updateSkillProgress(String studentId, List<SkillProgressDTO> skillProgressList) {
        // Fetch existing skill progress for the student
        List<SkillProgress> existingSkillProgress = skillProgressRepository.findByStudentId(studentId);

        // Perform updates for each SkillProgressDTO in skillProgressList
        for (SkillProgressDTO dto : skillProgressList) {
            // Find existing SkillProgress entry
            Optional<SkillProgress> existingProgressOpt = existingSkillProgress.stream()
                    .filter(sp -> sp.getSkillId().equals(dto.getSkillId()))
                    .findFirst();

            SkillProgress updatedSkillProgress;
            if (existingProgressOpt.isPresent()) {
                // If it exists, update it
                updatedSkillProgress = existingProgressOpt.get();
                updatedSkillProgress.setProgressLevel(dto.getProgressLevel());
                updatedSkillProgress.setProgressPercentage(dto.getProgressPercentage());
            } else {
                // If it doesn't exist, create a new entry
                updatedSkillProgress = mapDtoToEntity(dto, studentId);
            }
            // Save each updated skill progress entry
            skillProgressRepository.save(updatedSkillProgress);
        }
    }

    // Helper function to map DTO to entity
    private SkillProgress mapDtoToEntity(SkillProgressDTO dto, String studentId) {
        SkillProgress skillProgress = new SkillProgress();
        skillProgress.setSkillId(dto.getSkillId());
        skillProgress.setProgressPercentage(dto.getProgressPercentage());
        skillProgress.setProgressLevel(dto.getProgressLevel());
        skillProgress.setStudentId(studentId); // Ensure studentId is set
        return skillProgress;
    }

    // Delete skill progress entry by ID (with validation for studentId)
    public void deleteSkillProgress(String studentId, String id) {
        Optional<SkillProgress> skillProgressOpt = skillProgressRepository.findById(id);
        if (skillProgressOpt.isPresent() && skillProgressOpt.get().getStudentId().equals(studentId)) {
            skillProgressRepository.deleteById(id);
        } else {
            // Handle case where skill progress is not found or studentId does not match
            throw new IllegalArgumentException("Skill progress not found or mismatch with studentId");
        }
    }
}
