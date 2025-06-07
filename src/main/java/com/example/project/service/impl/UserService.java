package com.example.project.service.impl;

import org.springframework.stereotype.Service;

import com.example.project.dto.UserDTO;
import com.example.project.request.LoginRequest;
import com.example.project.response.LoginResponse;
import com.example.project.service.base.BaseService;
import com.example.project.service.interfaces.UserServiceInterface;

@Service
public class UserService extends BaseService implements UserServiceInterface {

    @Override
    public LoginResponse login(LoginRequest request) {
        
        try {
            // String email = request.getEmail();
            // String password = request.getPassword();

            String token = "1asndjnajsdjaasn";
            UserDTO user = new UserDTO(1L, "21123");

            return new LoginResponse(token, user);
            
        } catch (Exception e) {
            throw new RuntimeException("co loi xay ra");
        }
        
    }
    
}
