package com.example.project.service.impl;

import org.springframework.stereotype.Service;

import com.example.project.dto.StudentDTO;
import com.example.project.request.LoginRequest;
import com.example.project.response.LoginResponse;
import com.example.project.service.base.BaseService;
import com.example.project.service.interfaces.StudentServiceInterface;

@Service
public class StudentService extends BaseService implements StudentServiceInterface {

    @Override
    public LoginResponse login(LoginRequest request) {
        
        try {
            // String email = request.getEmail();
            // String password = request.getPassword();

            String token = "1asndjnajsdjaasn";
            StudentDTO student = new StudentDTO(1L, "21123");

            return new LoginResponse(token, student);
            
        } catch (Exception e) {
            throw new RuntimeException("co loi xay ra");
        }
        
    }
    
}
