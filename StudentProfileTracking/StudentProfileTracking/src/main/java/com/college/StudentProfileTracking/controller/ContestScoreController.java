package com.college.StudentProfileTracking.controller;

import com.college.StudentProfileTracking.dto.ScoreDTO; // Correct DTO import
import com.college.StudentProfileTracking.entity.ContestScore;
import com.college.StudentProfileTracking.service.ContestScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ContestScoreController {

    @Autowired
    private ContestScoreService contestScoreService;

    // POST endpoint to submit a score
    @PostMapping
    public ResponseEntity<ContestScore> submitScore(@RequestBody ContestScore score) {
        ContestScore savedScore = contestScoreService.submitScore(score);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedScore);
    }

    // GET endpoint to retrieve all scores
    @GetMapping
    public ResponseEntity<List<ScoreDTO>> getAllScores() {
        List<ScoreDTO> scores = contestScoreService.getAllScores(); // Get list of ScoreDTOs
        if (scores.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 if no content
        }
        return ResponseEntity.ok(scores);
    }


    // Additional endpoints can be added here (e.g., get scores by studentId, contestId)
}
