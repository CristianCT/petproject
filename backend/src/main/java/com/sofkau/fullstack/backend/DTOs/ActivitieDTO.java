package com.sofkau.fullstack.backend.DTOs;

public class ActivitieDTO {

    private String name;
    private Boolean completed;

    public ActivitieDTO() {
    }

    public ActivitieDTO(String name, Boolean completed) {
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
