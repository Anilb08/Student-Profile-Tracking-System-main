package com.college.StudentProfileTracking.controller;

import com.college.StudentProfileTracking.dto.RankingDTO;
import com.college.StudentProfileTracking.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rankings")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    // Endpoint to calculate rankings
    @PostMapping("/calculate")
    public ResponseEntity<String> calculateRankings() {
        try {
            rankingService.calculateAndUpdateRankings();
            return ResponseEntity.ok("Rankings calculated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to calculate rankings.");
        }
    }

    // Endpoint to get all rankings
    @GetMapping
    public ResponseEntity<List<RankingDTO>> getAllRankings() {
        List<RankingDTO> rankings = rankingService.getAllRankings();
        if (rankings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rankings);
    }

    // Endpoint to get ranking by student ID
    @GetMapping("/{studentId}")
    public ResponseEntity<RankingDTO> getRankingByStudentId(@PathVariable String studentId) {
        RankingDTO ranking = rankingService.getRankingByStudentId(studentId);
        if (ranking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ranking);
    }

    // Endpoint to get leaderboard with pagination
    @GetMapping("/leaderboard")
    public ResponseEntity<List<RankingDTO>> getLeaderboard(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<RankingDTO> leaderboard = rankingService.getTopRankings(page, size);
        if (leaderboard.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(leaderboard);
    }

    // Endpoint to add a new ranking
    @PostMapping
    public ResponseEntity<String> addRanking(@RequestBody RankingDTO rankingDTO) {
        try {
            rankingService.addRanking(rankingDTO);
            return ResponseEntity.ok("Ranking added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to add ranking.");
        }
    }

    // Endpoint to get top rankings by total contest score
    @GetMapping("/top-total-contest-score")
    public ResponseEntity<List<RankingDTO>> getTopTotalContestScore(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<RankingDTO> leaderboard = rankingService.getTopRankingsByTotalContestScore(page, size);
        if (leaderboard.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(leaderboard);
    }

    // Endpoint to get leaderboard by total score
    @GetMapping("/leaderboard-by-total-score")
    public ResponseEntity<List<RankingDTO>> getLeaderboardByTotalScore(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<RankingDTO> leaderboard = rankingService.getLeaderboardByTotalScore(page, size);
        if (leaderboard.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(leaderboard);
    }
}
