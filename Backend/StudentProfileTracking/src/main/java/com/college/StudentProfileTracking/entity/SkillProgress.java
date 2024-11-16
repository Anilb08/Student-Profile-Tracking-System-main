package com.college.StudentProfileTracking.entity;

public class SkillProgress {
    private String skillId;
    private double progressPercentage;
    private int progressLevel; // Assuming this is an integer
    private String studentId; // Add studentId field

    // No-argument constructor
    public SkillProgress() {
    }

    // Existing constructor (for cases where progressLevel isn't needed)
    public SkillProgress(String skillId, double progressPercentage) {
        this.skillId = skillId;
        this.progressPercentage = progressPercentage;
        this.progressLevel = 0; // Default value if progressLevel is not provided
    }

    // New constructor (to include progressLevel)
    public SkillProgress(String skillId, double progressPercentage, int progressLevel) {
        this.skillId = skillId;
        this.progressPercentage = progressPercentage;
        this.progressLevel = progressLevel;
    }

    // Getters and setters
    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public int getProgressLevel() {
        return progressLevel;
    }

    public void setProgressLevel(int progressLevel) {
        this.progressLevel = progressLevel;
    }

    public String getStudentId() {
        return studentId; // Getter for studentId
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId; // Setter for studentId
    }

    public int getSkillScore() {
        // Example calculation; adjust as needed for your logic
        return (int) (progressPercentage * progressLevel); // You can modify this formula
    }
}
