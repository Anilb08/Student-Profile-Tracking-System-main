package com.college.StudentProfileTracking.dto;

public class RankingDTO {
    private String id;
    private String studentId;
    private int totalContestScore;
    private double skillLevelScore;
    private int rank;
    private int skillsCount; // New field for skills count
    private int totalScore;  // New field for total score

    // Constructor including totalScore
    public RankingDTO(String id, String studentId, int totalContestScore, double skillLevelScore, int rank, int skillsCount, int totalScore) {
        this.id = id;
        this.studentId = studentId;
        this.totalContestScore = totalContestScore;
        this.skillLevelScore = skillLevelScore;
        this.rank = rank;
        this.skillsCount = skillsCount; // Initialize skills count
        this.totalScore = totalScore; // Initialize total score
    }

    // Default constructor
    public RankingDTO() {
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getTotalContestScore() {
        return totalContestScore;
    }

    public void setTotalContestScore(int totalContestScore) {
        this.totalContestScore = totalContestScore;
    }

    public double getSkillLevelScore() {
        return skillLevelScore;
    }

    public void setSkillLevelScore(double skillLevelScore) {
        this.skillLevelScore = skillLevelScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSkillsCount() {
        return skillsCount; // Return the actual skills count
    }

    public void setSkillsCount(int skillsCount) {
        this.skillsCount = skillsCount; // Set the skills count
    }

    // Setter for totalScore
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore; // Set the class field to the provided value
    }

    // Getter for totalScore
    public int getTotalScore() {
        return totalScore; // Return the actual total score
    }
}
