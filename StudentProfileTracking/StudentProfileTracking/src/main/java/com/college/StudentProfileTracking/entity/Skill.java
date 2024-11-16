package com.college.StudentProfileTracking.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "skills")
@Getter
@Setter
public class Skill {
    @Id
    private String id;
    private String name; // Name of the skill
    private String studentId; // Reference to the student owning this skill
}
