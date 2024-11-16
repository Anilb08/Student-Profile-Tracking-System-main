package com.college.StudentProfileTracking.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "contests")
@Getter // Automatically generates getters for all fields
@Setter // Automatically generates setters for all fields
public class Contest {
    @Id
    private String id; // Unique identifier for the contest
    private String name; // Name of the contest
    private LocalDate date; // Date of the contest
    // Add any other necessary fields related to the contest
}
