package com.college.StudentProfileTracking.service;

import com.college.StudentProfileTracking.entity.Roadmap;
import com.college.StudentProfileTracking.repository.RoadmapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoadmapService {
    @Autowired
    private RoadmapRepository roadmapRepository;

    public List<Roadmap> getAllRoadmaps() {
        return roadmapRepository.findAll();
    }

    public Roadmap getRoadmapById(String id) {
        return roadmapRepository.findById(id).orElse(null);
    }

    public Roadmap createRoadmap(Roadmap roadmap) {
        roadmap.setCreatedDate(LocalDate.now());
        roadmap.setUpdatedDate(LocalDate.now());
        return roadmapRepository.save(roadmap);
    }

    public Roadmap updateRoadmap(String id, Roadmap roadmap) {
        roadmap.setId(id);
        roadmap.setUpdatedDate(LocalDate.now());
        return roadmapRepository.save(roadmap);
    }

    public void deleteRoadmap(String id) {
        roadmapRepository.deleteById(id);
    }
}
