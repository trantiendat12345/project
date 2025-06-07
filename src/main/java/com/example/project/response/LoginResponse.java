package com.example.project.response;

import com.example.project.dto.UserDTO;

public class LoginResponse {
    
    private final String token;
    private final UserDTO UserDTO;

    public LoginResponse(String token, UserDTO userDTO) {
        this.token = token;
        this.UserDTO = userDTO;
    }

    public String getToken() {
        return token;
    }

    public UserDTO getUserDTO() {
        return UserDTO;
    }
    
}
