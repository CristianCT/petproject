package com.sofkau.fullstack.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "users")
public class UserModel {

    @Id
    private String id;

    private String name;
    private String email;
    private String password;

    private ArrayList<ProjectModel> projects;

    public UserModel() {
    }

    public UserModel(String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.projects = new ArrayList<ProjectModel>();
    }

    public UserModel(String id, String name, String email, String password, ArrayList<ProjectModel> projects) {
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

    public ArrayList<ProjectModel> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<ProjectModel> projects) {
        this.projects = projects;
    }

    public void addProject(ProjectModel projectModel){
        this.projects.add(projectModel);
    }
}
