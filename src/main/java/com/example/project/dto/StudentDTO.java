package com.example.project.dto;

public class StudentDTO {
    
    private final Long id;
    private final String email;

    public StudentDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }
    
}
