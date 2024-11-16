package com.college.StudentProfileTracking.controller;

import com.college.StudentProfileTracking.entity.Roadmap;
import com.college.StudentProfileTracking.service.RoadmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roadmaps")
public class RoadmapController {
    @Autowired
    private RoadmapService roadmapService;

    @GetMapping
    public List<Roadmap> getAllRoadmaps() {
        return roadmapService.getAllRoadmaps();
    }

    @GetMapping("/{id}")
    public Roadmap getRoadmapById(@PathVariable String id) {
        return roadmapService.getRoadmapById(id);
    }

    @PostMapping
    public Roadmap createRoadmap(@RequestBody Roadmap roadmap) {
        return roadmapService.createRoadmap(roadmap);
    }

    @PutMapping("/{id}")
    public Roadmap updateRoadmap(@PathVariable String id, @RequestBody Roadmap roadmap) {
        return roadmapService.updateRoadmap(id, roadmap);
    }

    @DeleteMapping("/{id}")
    public void deleteRoadmap(@PathVariable String id) {
        roadmapService.deleteRoadmap(id);
    }
}
