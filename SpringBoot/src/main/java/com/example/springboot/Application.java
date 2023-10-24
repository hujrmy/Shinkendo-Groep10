package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello sd %s!", name);
    }

    @GetMapping("/testje")
    public List<Map<String, Object>> test() {
        String sql = "SELECT * FROM username";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

}
