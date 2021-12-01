package com.sofkau.fullstack.backend.controllers;

import com.sofkau.fullstack.backend.DTOs.UserDTO;
import com.sofkau.fullstack.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") String id){
        return userService.getById(id);
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable("id") String id, @RequestBody UserDTO userDTO){
        return userService.update(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id){
        UserDTO user = userService.getById(id);
        if(user != null){
            userService.delete(user);
            return "User deleted";
        }
        return "User not found";
    }
}
