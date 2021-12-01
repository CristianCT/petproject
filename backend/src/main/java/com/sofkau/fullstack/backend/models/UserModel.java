package com.sofkau.fullstack.backend.models;

import com.sofkau.fullstack.backend.DTOs.ProjectDTO;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@Document(collection = "users")
public class UserModel {

    @Id
    private String id;

    private String name;
    private String email;
    private String password;

    private ArrayList<ProjectDTO> projects;

    public UserModel() {
    }

    public UserModel(String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserModel(String id, String name, String email, String password, ArrayList<ProjectDTO> projects) {
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
}
