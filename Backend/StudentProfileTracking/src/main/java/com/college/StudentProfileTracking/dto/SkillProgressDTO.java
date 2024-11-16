package com.college.StudentProfileTracking.dto;

public class SkillProgressDTO {
    private String skillId; // ID of the skill
    private double progressPercentage; // Progress percentage for the skill
    private int progressLevel; // Level of progress for the skill

    // Constructor
    public SkillProgressDTO(String skillId, double progressPercentage, int progressLevel) {
        this.skillId = skillId;
        this.progressPercentage = progressPercentage;
        this.progressLevel = progressLevel; // Initialize progressLevel
    }

    // Getters and Setters
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
        return progressLevel; // Ensure this method is defined
    }

    public void setProgressLevel(int progressLevel) {
        this.progressLevel = progressLevel;
    }
}
