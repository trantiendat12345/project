package com.example.project.response;

import com.example.project.dto.StudentDTO;

public class LoginResponse {
    
    private final String token;
    private final StudentDTO studentDTO;

    public LoginResponse(String token, StudentDTO userDTO) {
        this.token = token;
        this.studentDTO = userDTO;
    }

    public String getToken() {
        return token;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }
    
}
