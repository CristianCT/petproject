package com.sofkau.fullstack.backend.controllers;

import com.sofkau.fullstack.backend.DTOs.ActivityDTO;
import com.sofkau.fullstack.backend.DTOs.ProjectDTO;
import com.sofkau.fullstack.backend.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/{userId}/{projectId}")
    public ArrayList<ActivityDTO> getAll(@PathVariable("userId") String userId, @PathVariable("projectId") String projectId){
        return activityService.getAll(userId, projectId);
    }

    @PostMapping("/{userId}/{projectId}")
    public ActivityDTO save(@PathVariable("userId") String userId, @PathVariable("projectId") String projectId, @RequestBody ActivityDTO activityDTO){
        return activityService.save(userId, projectId, activityDTO);
    }

    @GetMapping("/{userId}/{projectId}/{id}")
    public ActivityDTO getById(@PathVariable("userId") String userId, @PathVariable("projectId") String projectId, @PathVariable("id") String id){
        return activityService.getById(userId, projectId, id);
    }

    @PutMapping("/{userId}/{projectId}/{id}")
    public ActivityDTO update(@PathVariable("userId") String userId, @PathVariable("projectId") String projectId, @PathVariable("id") String id, @RequestBody ActivityDTO activityDTO){
        return activityService.update(userId, projectId, id, activityDTO);
    }

    @DeleteMapping("/{userId}/{projectId}/{id}")
    public String delete(@PathVariable("userId") String userId, @PathVariable("projectId") String projectId, @PathVariable("id") String id){
        ActivityDTO activity = activityService.getById(userId, projectId, id);
        if(activity != null){
            activityService.delete(userId, projectId, id);
            return "Activity deleted";
        }
        return "Activity not found";
    }
}
