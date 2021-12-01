package com.sofkau.fullstack.backend.controllers;

import com.sofkau.fullstack.backend.models.UserModel;
import com.sofkau.fullstack.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> list(){
        return userService.list();
    }

    @PostMapping
    public UserModel save(@RequestBody UserModel userModel){
        return userService.save(userModel);
    }
}
