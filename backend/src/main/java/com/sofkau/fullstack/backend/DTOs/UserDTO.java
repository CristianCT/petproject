package com.sofkau.fullstack.backend.DTOs;

import java.util.ArrayList;

public class UserDTO {

    private String id;
    private String name;
    private String email;
    private String password;
    private ArrayList<ProjectDTO> projects;

    public UserDTO() {
    }

    public UserDTO(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.projects = new ArrayList<ProjectDTO>();
    }

    public UserDTO(String id, String name, String email, String password, ArrayList<ProjectDTO> projects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.projects = projects;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<ProjectDTO> projects) {
        this.projects = projects;
    }

    public void addProject(ProjectDTO project) {
        this.projects.add(project);
    }
}
