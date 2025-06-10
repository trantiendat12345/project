package com.example.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.request.LoginRequest;
import com.example.project.response.LoginResponse;
import com.example.project.service.interfaces.StudentServiceInterface;
import com.example.project.util.ErrorResource;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        
        Object result = userServiceiInterface.login(request);

        if(result instanceof LoginResponse loginResponse) {
            return ResponseEntity.ok(loginResponse);
        }

        if(result instanceof ErrorResource errorResource) {
            return ResponseEntity.unprocessableEntity().body(errorResource);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Network Error");
        
    }
    
    
}
