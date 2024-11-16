package com.college.StudentProfileTracking.controller;


import com.college.StudentProfileTracking.entity.Contest;
import com.college.StudentProfileTracking.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contests")
public class ContestController {
    @Autowired
    private ContestService contestService;

    @GetMapping
    public List<Contest> getContests() {
        return contestService.getAllContests();
    }

    @PostMapping
    public Contest createContest(@RequestBody Contest contest) {
        return contestService.addContest(contest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContest(@PathVariable String id) {
        contestService.deleteContest(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}

