package com.college.StudentProfileTracking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rankings")
public class Ranking {

    @Id
    private String id;
    private String studentId;
    private int totalContestScore;
    private double skillLevelScore;  // Changed to double
    private int rank;  // Added rank field
    private int skillsCount;  // New field for skills count
    private int totalScore;  // New field for total score


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

    // Always returns 0 for skills count as per your requirement
    public int getSkillsCount() {
        return 0;
    }

//    public int getSkillsCount() {
//        return skillsCount;
//    }

    public void setSkillsCount(int skillsCount) {
        this.skillsCount = skillsCount;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
