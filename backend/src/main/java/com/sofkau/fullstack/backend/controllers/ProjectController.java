package com.sofkau.fullstack.backend.controllers;

import com.sofkau.fullstack.backend.DTOs.ProjectDTO;
import com.sofkau.fullstack.backend.DTOs.UserDTO;
import com.sofkau.fullstack.backend.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{userId}")
    public ArrayList<ProjectDTO> getAll(@PathVariable("userId") String userId){
        return projectService.getAll(userId);
    }

    @PostMapping("/{userId}")
    public ProjectDTO save(@PathVariable("userId") String userId, @RequestBody ProjectDTO projectDTO){
        return projectService.save(userId, projectDTO);
    }

    @GetMapping("/{userId}/{id}")
    public ProjectDTO getById(@PathVariable("userId") String userId, @PathVariable("id") String id){
        return projectService.getById(userId, id);
    }

    @PutMapping("/{userId}/{id}")
    public ProjectDTO update(@PathVariable("userId") String userId, @PathVariable("id") String id, @RequestBody ProjectDTO projectDTO){
        return projectService.update(userId, id, projectDTO);
    }

    @DeleteMapping("/{userId}/{id}")
    public String delete(@PathVariable("userId") String userId, @PathVariable("id") String id){
        ProjectDTO project = projectService.getById(userId, id);
        if(project != null){
            projectService.delete(userId, id);
            return "Project deleted";
        }
        return "Project not found";
    }
}
