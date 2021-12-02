package com.sofkau.fullstack.backend.services;

import com.sofkau.fullstack.backend.DTOs.ActivityDTO;
import com.sofkau.fullstack.backend.models.ActivityModel;
import com.sofkau.fullstack.backend.models.ProjectModel;
import com.sofkau.fullstack.backend.models.UserModel;
import com.sofkau.fullstack.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActivityService {
    @Autowired
    private UserRepository userRepository;

    public ActivityDTO save(String userId, String projectId, ActivityDTO activityDTO){
        UserModel user = userRepository.findById(userId).orElseThrow();
        ProjectModel project = user.getProjects().get(Integer.parseInt(projectId));
        ActivityModel activity = new ActivityModel(activityDTO.getName(), activityDTO.getCompleted());
        project.addActivity(activity);
        user.getProjects().set(Integer.parseInt(projectId), project);
        userRepository.save(user);
        return activityDTO;
    }

    public ArrayList<ActivityDTO> getAll(String userId, String projectId){
        UserModel user = userRepository.findById(userId).orElseThrow();
        ProjectModel project = user.getProjects().get(Integer.parseInt(projectId));
        return activityModelParseActivitytDTO(project.getActivities());
    }

    public ActivityDTO getById(String userId, String projectId, String id){
        ArrayList<ActivityDTO> activities = getAll(userId, projectId);
        return activities.get(Integer.parseInt(id));
    }

    public ActivityDTO update(String userId, String projectId, String id, ActivityDTO activityDTO){
        UserModel user = userRepository.findById(userId).orElseThrow();
        ProjectModel project = user.getProjects().get(Integer.parseInt(id));
        ActivityModel activityOld = project.getActivities().get(Integer.parseInt(id));
        ActivityModel activityNew = new ActivityModel(
            activityDTO.getName() != null? activityDTO.getName() : activityOld.getName(),
            activityDTO.getCompleted() != null? activityDTO.getCompleted():activityOld.getCompleted()
        );
        project.getActivities().set(Integer.parseInt(id), activityNew);
        user.getProjects().set(Integer.parseInt(projectId),project);
        userRepository.save(user);
        ArrayList<ActivityDTO> activitiesDTO = activityModelParseActivitytDTO(project.getActivities());
        return activitiesDTO.get(Integer.parseInt(id));
    }

    public void delete(String userId, String projectId, String id){
        UserModel user = userRepository.findById(userId).orElseThrow();
        ProjectModel project = user.getProjects().get(Integer.parseInt(projectId));
        ArrayList<ActivityModel> activities = project.getActivities();
        activities.remove(Integer.parseInt(id));
        project.setActivities(activities);
        user.getProjects().set(Integer.parseInt(projectId),project);
        userRepository.save(user);
    }

    private ArrayList<ActivityDTO> activityModelParseActivitytDTO(ArrayList<ActivityModel> activities){
        ArrayList<ActivityDTO> activitiesDTO = new ArrayList<>();
        for(ActivityModel activity: activities){
            ActivityDTO activityDTO = new ActivityDTO(activity.getName(),activity.getCompleted());
            activitiesDTO.add(activityDTO);
        }
        return activitiesDTO;
    }
}
