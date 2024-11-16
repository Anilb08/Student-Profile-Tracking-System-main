package com.college.StudentProfileTracking.service;

import com.college.StudentProfileTracking.dto.RankingDTO;
import com.college.StudentProfileTracking.entity.Ranking;
import com.college.StudentProfileTracking.repository.RankingRepository;
import com.college.StudentProfileTracking.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    @Autowired
    private SkillRepository skillRepository;

    // Method to add a new ranking
    public void addRanking(RankingDTO rankingDTO) {
        Ranking ranking = new Ranking();
        ranking.setStudentId(rankingDTO.getStudentId());
        ranking.setTotalContestScore(rankingDTO.getTotalContestScore());
        ranking.setSkillLevelScore(rankingDTO.getSkillLevelScore());
        ranking.setRank(rankingDTO.getRank());

        // Calculate skills count and total score based on ranking criteria
        ranking.setSkillsCount(calculateSkillsCount(rankingDTO.getStudentId()));
        ranking.setTotalScore(calculateTotalScore(ranking));

        rankingRepository.save(ranking);
    }

    // Calculate skills count for a student
    private int calculateSkillsCount(String studentId) {
        return skillRepository.countByStudentId(studentId);
    }

    // Calculate the total score using the ranking formula
    private int calculateTotalScore(Ranking ranking) {
        return (int) (0.5 * ranking.getTotalContestScore() +
                0.3 * ranking.getSkillLevelScore() +
                0.2 * ranking.getSkillsCount());
    }

    // Retrieve all rankings as DTOs
    public List<RankingDTO> getAllRankings() {
        List<Ranking> rankings = rankingRepository.findAll();
        return rankings.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convert Ranking entity to RankingDTO
    private RankingDTO convertToDTO(Ranking ranking) {
        RankingDTO rankingDTO = new RankingDTO();
        rankingDTO.setId(ranking.getId().toString());
        rankingDTO.setStudentId(ranking.getStudentId());
        rankingDTO.setTotalContestScore(ranking.getTotalContestScore());
        rankingDTO.setSkillLevelScore(ranking.getSkillLevelScore());
        rankingDTO.setRank(ranking.getRank());
        rankingDTO.setSkillsCount(ranking.getSkillsCount());
        rankingDTO.setTotalScore(ranking.getTotalScore());
        return rankingDTO;
    }

    // Retrieve top rankings by total contest score
    public List<RankingDTO> getTopRankingsByTotalContestScore(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("totalContestScore").descending());
        List<Ranking> rankings = rankingRepository.findAll(pageable).getContent();
        return rankings.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Retrieve ranking by student ID
    public RankingDTO getRankingByStudentId(String studentId) {
        Ranking ranking = rankingRepository.findByStudentId(studentId);
        return ranking != null ? convertToDTO(ranking) : null;
    }

    // Placeholder for ranking calculation logic
    public void calculateAndUpdateRankings() {
        // Implement logic to calculate and update rankings if needed
    }

    // Retrieve a paginated list of top rankings sorted by totalScore in descending order
    public List<RankingDTO> getTopRankings(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("totalScore").descending());
        List<Ranking> rankings = rankingRepository.findAll(pageable).getContent();
        return rankings.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<RankingDTO> getLeaderboardByTotalScore(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Ranking> rankings = rankingRepository.findAllByOrderByTotalScoreDesc(pageable).getContent();
        return rankings.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
