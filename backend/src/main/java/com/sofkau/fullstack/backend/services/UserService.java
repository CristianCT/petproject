package com.sofkau.fullstack.backend.services;

import com.sofkau.fullstack.backend.DTOs.ActivityDTO;
import com.sofkau.fullstack.backend.DTOs.ProjectDTO;
import com.sofkau.fullstack.backend.DTOs.UserDTO;
import com.sofkau.fullstack.backend.models.ActivityModel;
import com.sofkau.fullstack.backend.models.ProjectModel;
import com.sofkau.fullstack.backend.models.UserModel;
import com.sofkau.fullstack.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO save(UserDTO userDTO){
        UserModel user = new UserModel(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());
        UserModel newUser = userRepository.save(user);
        userDTO.setId(newUser.getId());
        return userDTO;
    }

    public UserDTO update(String id, UserDTO userDTO) {
        UserModel user = userRepository.findById(id).orElseThrow();
        user.setName(userDTO.getName()!= null? userDTO.getName():user.getName());
        user.setEmail(userDTO.getEmail()!= null? userDTO.getEmail():user.getEmail());
        user.setPassword(userDTO.getPassword()!= null? userDTO.getPassword():user.getPassword());
        user.setProjects(userDTO.getProjects()!= null? projectDTOParseProjectModel(userDTO.getProjects()):user.getProjects());
        UserModel newUser = userRepository.save(user);
        userDTO.setId(newUser.getId());
        return userDTO;
    }

    public UserDTO getById(String id){
        UserModel userModel = userRepository.findById(id).orElseThrow();
        return new UserDTO(userModel.getId(),
                userModel.getName(),
                userModel.getEmail(),
                userModel.getPassword(),
                projectModelParseProjectDTO(userModel.getProjects())
        );
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }

    public void delete(UserDTO userDTO){
        UserModel user = new UserModel(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                projectDTOParseProjectModel(userDTO.getProjects())
        );
        userRepository.delete(user);
    }

    private ArrayList<ProjectModel> projectDTOParseProjectModel (ArrayList<ProjectDTO> projects){
        ArrayList<ProjectModel> projectsModel = new ArrayList<ProjectModel>();
        for(ProjectDTO project: projects){
            ProjectModel projectModel = new ProjectModel(project.getName(),activityDTOParseActivitytModel(project.getActivities()));
            projectsModel.add(projectModel);
        }
        return projectsModel;
    }

    private ArrayList<ActivityModel> activityDTOParseActivitytModel(ArrayList<ActivityDTO> activities){
        ArrayList<ActivityModel> activitiesModel = new ArrayList<ActivityModel>();
        for(ActivityDTO activity: activities){
            ActivityModel activityModel = new ActivityModel(activity.getName(),activity.getCompleted());
            activitiesModel.add(activityModel);
        }
        return activitiesModel;
    }

    private ArrayList<ProjectDTO> projectModelParseProjectDTO (ArrayList<ProjectModel> projects){
        ArrayList<ProjectDTO> projectsDTO = new ArrayList<ProjectDTO>();
        for(ProjectModel project: projects){
            ProjectDTO projectDTO = new ProjectDTO(project.getName(),activityModelParseActivitytDTO(project.getActivities()));
            projectsDTO.add(projectDTO);
        }
        return projectsDTO;
    }

    private ArrayList<ActivityDTO> activityModelParseActivitytDTO(ArrayList<ActivityModel> activities){
        ArrayList<ActivityDTO> activitiesDTO = new ArrayList<ActivityDTO>();
        for(ActivityModel activity: activities){
            ActivityDTO activityDTO = new ActivityDTO(activity.getName(),activity.getCompleted());
            activitiesDTO.add(activityDTO);
        }
        return activitiesDTO;
    }
}
