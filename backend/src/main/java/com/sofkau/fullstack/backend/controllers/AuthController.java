package com.sofkau.fullstack.backend.controllers;

import com.sofkau.fullstack.backend.DTOs.UserDTO;
import com.sofkau.fullstack.backend.auth.AuthService;
import com.sofkau.fullstack.backend.auth.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping()
    public String login(@RequestBody UserDTO userDTO){
        return authService.login(userDTO);
    }
}
