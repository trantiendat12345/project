package com.example.project.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project.dto.StudentDTO;
import com.example.project.entity.Student;
import com.example.project.repository.StudentRepository;
import com.example.project.request.LoginRequest;
import com.example.project.response.LoginResponse;
import com.example.project.security.JwtSecurity;
import com.example.project.service.base.BaseService;
import com.example.project.service.interfaces.StudentServiceInterface;
import com.example.project.util.ErrorResource;

@Service
public class StudentService extends BaseService implements StudentServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private JwtSecurity jwtSecurity;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Object login(LoginRequest request) {
        
        try {

            Student student = studentRepository.findByEmail(request.getEmail()).orElseThrow(() -> new BadCredentialsException("Email hoặc mật khẩu không chính xác"));

            if(!passwordEncoder.matches(request.getPassword(), student.getPassword())) {
                throw new BadCredentialsException("Email hoặc mật khẩu không chính xác");
            }

            StudentDTO studentDTO = new StudentDTO(student.getId(), student.getEmail(), student.getFullName(), student.getClassId(), student.getPhone(), student.getStatus());
            String token = jwtSecurity.generateToken(student.getId(), student.getEmail());

            return new LoginResponse(token, studentDTO);
            
        } catch (BadCredentialsException e) {
            logger.error("Lỗi xác thực người dùng", e.getMessage());    

            Map<String, String> errors = new HashMap<>();
            errors.put("message", e.getMessage());
            ErrorResource error = new ErrorResource("Có vấn đề xảy ra trong quá trình xác thực", errors);
            return error;
            
        }
        
    }
    
}
