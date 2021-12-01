package com.sofkau.fullstack.backend.services;

import com.sofkau.fullstack.backend.DTOs.UserDTO;
import com.sofkau.fullstack.backend.models.UserModel;
import com.sofkau.fullstack.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO save(UserDTO userDTO){
        UserModel user = new UserModel(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());
        UserModel newUser = userRepository.save(user);
        userDTO.setId(newUser.getId());
        return userDTO;
    }

    public UserDTO update(String id, UserDTO userDTO) {
        UserModel user = userRepository.findById(id).orElseThrow();
        user.setName(userDTO.getName()!= null? userDTO.getName():user.getName());
        user.setEmail(userDTO.getEmail()!= null? userDTO.getEmail():user.getEmail());
        user.setPassword(userDTO.getPassword()!= null? userDTO.getPassword():user.getPassword());
        user.setProjects(userDTO.getProjects()!= null? userDTO.getProjects():user.getProjects());
        UserModel newUser = userRepository.save(user);
        userDTO.setId(newUser.getId());
        return userDTO;
    }

    public UserDTO getById(String id){
        UserModel userModel = userRepository.findById(id).orElseThrow();
        UserDTO user = new UserDTO(userModel.getId(),
                userModel.getName(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getProjects()
        );
        return user;
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }

    public void delete(UserDTO userDTO){
        UserModel user = new UserModel(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getProjects()
        );
        userRepository.delete(user);
    }
}
