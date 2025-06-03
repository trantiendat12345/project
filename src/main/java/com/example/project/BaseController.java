package com.example.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("app")
public class BaseController {

    private final JdbcTemplate jdbcTemplate;

    public BaseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("test")
    public String test() {

        return "Completed";
    }
    
}
