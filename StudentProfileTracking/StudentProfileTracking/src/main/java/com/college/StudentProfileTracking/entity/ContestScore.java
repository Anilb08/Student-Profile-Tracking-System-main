package com.college.StudentProfileTracking.entity;

import org.springframework.data.annotation.Id;
import java.util.Date; // or LocalDateTime

public class ContestScore {

    @Id
    private String id; // The unique identifier for each score

    private String studentId; // Assuming studentId is a String
    private String contestId; // Assuming contestId is a String
    private int score; // Assuming score is an integer
    private String contestName; // Ensure this is a String
    private Date date; // Ensure this is a Date (or LocalDateTime)

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
