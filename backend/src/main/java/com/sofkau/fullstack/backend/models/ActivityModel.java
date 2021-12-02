package com.sofkau.fullstack.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;

@Document
public class ActivityModel {

    @Id
    @GeneratedValue
    private String id;

    private String name;
    private Boolean completed;

    public ActivityModel() {
    }

    public ActivityModel(String name) {
        this.name = name;
        this.completed = false;
    }

    public ActivityModel(String name, Boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    public ActivityModel(String id, String name, Boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
