package com.sofkau.fullstack.backend.auth;

import com.sofkau.fullstack.backend.DTOs.UserDTO;
import com.sofkau.fullstack.backend.models.UserModel;
import com.sofkau.fullstack.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtProvider jwt;

    @Autowired
    private UserRepository userRepository;

    public String login(UserDTO userDTO){
        UserModel user = userRepository.findByEmail(userDTO.getEmail());
        if(user != null){
            if(user.getPassword().equals(userDTO.getPassword())){
                return jwt.generateToken(userDTO);
            }
            return "Contrasña incorrecta";
        }
        return "El usuario no existe";
    }
}
