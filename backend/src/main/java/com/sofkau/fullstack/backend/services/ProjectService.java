package com.sofkau.fullstack.backend.services;

import com.sofkau.fullstack.backend.DTOs.ActivityDTO;
import com.sofkau.fullstack.backend.DTOs.ProjectDTO;
import com.sofkau.fullstack.backend.models.ActivityModel;
import com.sofkau.fullstack.backend.models.ProjectModel;
import com.sofkau.fullstack.backend.models.UserModel;
import com.sofkau.fullstack.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectService {

    @Autowired
    private UserRepository userRepository;

    public ProjectDTO save(String userId, ProjectDTO projectDTO){
        UserModel user = userRepository.findById(userId).orElseThrow();
        ProjectModel project = new ProjectModel(projectDTO.getName());
        user.addProject(project);
        userRepository.save(user);
        return projectDTO;
    }

    public ArrayList<ProjectDTO> getAll(String userId){
        UserModel user = userRepository.findById(userId).orElseThrow();
        return projectModelParseProjectDTO(user.getProjects());
    }

    public ProjectDTO getById(String userId, String id){
        ArrayList<ProjectDTO> projects = getAll(userId);
        return projects.get(Integer.parseInt(id));
    }

    public ProjectDTO update(String userId, String id, ProjectDTO projectDTO){
        UserModel user = userRepository.findById(userId).orElseThrow();
        ProjectModel projectOld = user.getProjects().get(Integer.parseInt(id));
        ProjectModel projectNew = new ProjectModel(
                projectDTO.getName()!=null?projectDTO.getName(): projectOld.getName(),
                projectOld.getActivities()
        );
        user.getProjects().set(Integer.parseInt(id),projectNew);
        userRepository.save(user);
        ArrayList<ProjectDTO> projectsDTO = projectModelParseProjectDTO(user.getProjects());
        return projectsDTO.get(Integer.parseInt(id));
    }

    public void delete(String userId, String id){
        UserModel user = userRepository.findById(userId).orElseThrow();
        ArrayList<ProjectModel> projects = user.getProjects();
        projects.remove(Integer.parseInt(id));
        user.setProjects(projects);
        userRepository.save(user);
    }

    private ArrayList<ProjectDTO> projectModelParseProjectDTO (ArrayList<ProjectModel> projects){
        ArrayList<ProjectDTO> projectsDTO = new ArrayList<>();
        for(ProjectModel project: projects){
            ProjectDTO projectDTO = new ProjectDTO(project.getName(),activityModelParseActivitytDTO(project.getActivities()));
            projectsDTO.add(projectDTO);
        }
        return projectsDTO;
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
