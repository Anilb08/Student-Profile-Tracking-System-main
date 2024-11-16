package com.college.StudentProfileTracking.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Collection;
import java.util.List;

@Document(collection = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student implements UserDetails {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String username;

    private String email;
    private String password;
    private String skillLevel; // Existing field
    private List<String> skillIds; // List of skill IDs related to this student
    private String rankingId; // Reference to the student's ranking
    private List<SkillProgress> skillProgress; // New field to track skill progress

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password); // Encrypting the password
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // Customize if you have roles
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Object getName() {
        return null;
    }



    public List<SkillProgress> getSkillProgress() {
        return skillProgress;
    }

    public void setSkillProgress(List<SkillProgress> skillProgress) {
        this.skillProgress = skillProgress;
    }

    public void setSkillIds(List<String> skillIds) {
        this.skillIds = skillIds;
    }

    public List<String> getSkillIds() {
        return skillIds;
    }
}
