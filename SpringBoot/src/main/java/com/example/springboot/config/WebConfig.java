package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CORS configuration applied");
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "https://159.65.194.205", "http://159.65.194.205",
                        "http://159.65.194.205:8080", "https://oyster-app-hhkq7.ondigitalocean.app",
                        "https://fuujokan-amsterdam.online", "https://fuujokan-amsterdam.online:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true);
    }

}

