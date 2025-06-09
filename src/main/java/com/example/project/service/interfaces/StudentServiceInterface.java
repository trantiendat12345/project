package com.example.project.service.interfaces;

import com.example.project.request.LoginRequest;
import com.example.project.response.LoginResponse;

public interface StudentServiceInterface {

    LoginResponse login(LoginRequest request);
    
}
