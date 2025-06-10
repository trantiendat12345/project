package com.example.project.dto;

import lombok.Data;

@Data
public class StudentDTO {
    
    private final Long id;
    private final String email;
    private final String fullName;
    private final Long classId;
    private final String phone;
    private final String status;

    public StudentDTO (Long id, String email, String fullName, Long classId, String phone, String status) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.classId = classId;
        this.phone = phone;
        this.status = status;
    }
    
}
