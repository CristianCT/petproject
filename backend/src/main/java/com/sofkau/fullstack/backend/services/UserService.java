package com.sofkau.fullstack.backend.services;

import com.sofkau.fullstack.backend.models.UserModel;
import com.sofkau.fullstack.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<UserModel> list(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }
}
