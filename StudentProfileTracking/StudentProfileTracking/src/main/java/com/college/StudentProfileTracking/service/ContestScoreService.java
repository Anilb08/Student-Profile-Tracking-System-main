package com.college.StudentProfileTracking.service;

import com.college.StudentProfileTracking.dto.ScoreDTO;
import com.college.StudentProfileTracking.entity.ContestScore;
import com.college.StudentProfileTracking.repository.ContestScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContestScoreService {

    @Autowired
    private ContestScoreRepository contestScoreRepository;

    // Method to submit a new score
    public ContestScore submitScore(ContestScore score) {
        return contestScoreRepository.save(score);
    }

    // Method to get all scores
    public List<ScoreDTO> getAllScores() {
        List<ContestScore> scores = contestScoreRepository.findAll();
        return scores.stream()
                .map(score -> new ScoreDTO(
                        score.getStudentId(),
                        score.getContestId(),
                        score.getScore(),
                        score.getContestName(),
                        score.getDate()))
                .collect(Collectors.toList());
    }
}
