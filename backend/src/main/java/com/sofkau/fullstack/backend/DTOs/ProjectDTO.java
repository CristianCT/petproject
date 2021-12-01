package com.sofkau.fullstack.backend.DTOs;

import java.util.ArrayList;

public class ProjectDTO {

    private String name;
    private ArrayList<ActivitieDTO> activities;

    public ProjectDTO() {
    }

    public ProjectDTO(String name) {
        this.name = name;
        this.activities = new ArrayList();
    }

    public ProjectDTO(String name, ArrayList<ActivitieDTO> activities) {
        this.name = name;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ActivitieDTO> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<ActivitieDTO> activities) {
        this.activities = activities;
    }

    public void addActivitie(ActivitieDTO activitie){
        this.activities.add(activitie);
    }
}
