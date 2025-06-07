package com.example.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.request.LoginRequest;
import com.example.project.response.LoginResponse;
import com.example.project.service.interfaces.UserServiceInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("web")
public class AuthController {

    private final UserServiceInterface userServiceiInterface;

    public AuthController(UserServiceInterface userServiceiInterface) {
        this.userServiceiInterface = userServiceiInterface;
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        
        LoginResponse auth = userServiceiInterface.login(request);

        return ResponseEntity.ok(auth);
        
    }
    
    
}
