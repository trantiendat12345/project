package com.example.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.request.LoginRequest;
import com.example.project.response.LoginResponse;
import com.example.project.service.interfaces.StudentServiceInterface;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
@RequestMapping("web")
public class AuthController {

    private final StudentServiceInterface userServiceiInterface;

    public AuthController(StudentServiceInterface userServiceiInterface) {
        this.userServiceiInterface = userServiceiInterface;
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        
        LoginResponse auth = userServiceiInterface.login(request);

        return ResponseEntity.ok(auth);
        
    }
    
    
}
