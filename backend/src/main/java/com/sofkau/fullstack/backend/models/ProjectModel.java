package com.sofkau.fullstack.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;

@Document
public class ProjectModel {

    @Id
    @GeneratedValue
    private String id;

    private String name;
    private ArrayList<ActivityModel> activities;

    public ProjectModel() {
    }

    public ProjectModel(String name) {
        this.name = name;
        this.activities = new ArrayList<ActivityModel>();
    }

    public ProjectModel(String name, ArrayList<ActivityModel> activities) {
        this.name = name;
        this.activities = activities;
    }

    public ProjectModel(String id, String name, ArrayList<ActivityModel> activities) {
        this.id = id;
        this.name = name;
        this.activities = activities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ActivityModel> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<ActivityModel> activities) {
        this.activities = activities;
    }

    public void addActivity(ActivityModel activityModel){
        this.activities.add(activityModel);
    }
}
