package com.example.project.response;

import com.example.project.dto.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    
    private final String token;
    private final StudentDTO studentDTO;
    
}
