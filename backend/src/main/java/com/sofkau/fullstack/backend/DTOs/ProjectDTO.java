package com.sofkau.fullstack.backend.DTOs;

import java.util.ArrayList;

public class ProjectDTO {

    private String name;
    private ArrayList<ActivityDTO> activities;

    public ProjectDTO() {
    }

    public ProjectDTO(String name) {
        this.name = name;
        this.activities = new ArrayList<ActivityDTO>();
    }

    public ProjectDTO(String name, ArrayList<ActivityDTO> activities) {
        this.name = name;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ActivityDTO> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<ActivityDTO> activities) {
        this.activities = activities;
    }

    public void addActivity(ActivityDTO activityDTO){
        this.activities.add(activityDTO);
    }
}
