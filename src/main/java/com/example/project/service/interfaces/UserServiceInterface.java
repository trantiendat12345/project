package com.example.project.service.interfaces;

import com.example.project.request.LoginRequest;
import com.example.project.response.LoginResponse;

public interface UserServiceInterface {

    LoginResponse login(LoginRequest request);
    
}
