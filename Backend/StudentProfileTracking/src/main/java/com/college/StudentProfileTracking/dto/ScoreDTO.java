package com.college.StudentProfileTracking.dto;

import java.util.Date; // or java.time.LocalDateTime if you are using it

public class ScoreDTO {
    private String studentId;
    private String contestId;
    private int score;
    private String contestName;
    private Date date; // or LocalDateTime

    // Constructor
    public ScoreDTO(String studentId, String contestId, int score, String contestName, Date date) {
        this.studentId = studentId;
        this.contestId = contestId;
        this.score = score;
        this.contestName = contestName;
        this.date = date;
    }

    // Getters and Setters
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

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
