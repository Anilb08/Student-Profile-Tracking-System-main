package com.college.StudentProfileTracking.service;


import com.college.StudentProfileTracking.entity.Contest;
import com.college.StudentProfileTracking.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {
    @Autowired
    private ContestRepository contestRepository;

    public List<Contest> getAllContests() {
        return contestRepository.findAll();
    }

    public Contest addContest(Contest contest) {
        return contestRepository.save(contest);
    }

    public void deleteContest(String id) {
        contestRepository.deleteById(id);
    }
}
