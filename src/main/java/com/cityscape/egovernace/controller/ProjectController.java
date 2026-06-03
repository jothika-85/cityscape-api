package com.cityscape.egovernace.controller;

import com.cityscape.egovernace.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import com.cityscape.egovernace.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    // 1. Admin Tender Publish panna
    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        // Project ID generation logic (e.g., PRJ-101) inga add pannalaam
        if (project.getProjectId() == null) {
            project.setProjectId("PRJ-" + System.currentTimeMillis() % 1000);
        }
        return projectRepository.save(project);
    }

    // 2. Public and Others view panna
    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}