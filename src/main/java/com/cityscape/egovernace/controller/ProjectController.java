package com.cityscape.egovernace.controller;

import com.cityscape.egovernace.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import com.cityscape.egovernace.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "https://cityscape-ui.vercel.app")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    
    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        
        if (project.getProjectId() == null) {
            project.setProjectId("PRJ-" + System.currentTimeMillis() % 1000);
        }
        return projectRepository.save(project);
    }

    
    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}