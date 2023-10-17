package com.example.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
public class SpringbootToPostgres implements CommandLineRunner{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping("/test")
    public SpringbootToPostgres test(@RequestBody SpringbootToPostgres stp){
        String sql = "SELECT * FROM Shinkendo";
        int rows = jdbcTemplate.update(sql);
        return stp;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootToPostgres.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM Shinkendo";

        /*int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }*/
    }
}
