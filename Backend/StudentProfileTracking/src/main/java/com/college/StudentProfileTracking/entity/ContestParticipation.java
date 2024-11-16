package com.college.StudentProfileTracking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contest_participation")
public class ContestParticipation {

    @Id
    private String id;
    private String studentId;  // Student ID for the participant
    private String contestId;  // Contest ID
    private int score;         // Score achieved in this contest

    // Constructors, Getters, and Setters
    public ContestParticipation() {}

    public ContestParticipation(String studentId, String contestId, int score) {
        this.studentId = studentId;
        this.contestId = contestId;
        this.score = score;
    }

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

    public String getContestId() {
        return contestId;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
