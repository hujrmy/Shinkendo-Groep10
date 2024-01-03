package com.example.springboot.config;

import com.example.springboot.model.User;
import com.example.springboot.model.Rights;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers("/api/v1/auth/authenticate")
                                .permitAll()
                                .requestMatchers(POST, "api/v1/auth/register").hasAnyAuthority("ADMIN")
                                .requestMatchers(GET, "api/attendanceList").hasAnyAuthority("SENSEI", "ADMIN")
                                .requestMatchers(POST, "api/attendanceList").hasAnyAuthority("SENSEI", "ADMIN")
                                .requestMatchers(POST, "api/curriculum").hasAnyAuthority("SENSEI", "ADMIN")
                                .requestMatchers(POST, "api/dojo").hasAnyAuthority("ADMIN")
                                .requestMatchers(POST, "api/exercise").hasAnyAuthority("SENSEI", "ADMIN")
                                .requestMatchers(POST, "api/lesson").hasAnyAuthority("SENSEI", "ADMIN")
                                .requestMatchers(DELETE, "api/curriculum/{curriculumId}").hasAnyAuthority("ADMIN")
                                .requestMatchers(GET, "api/userExercises").hasAnyAuthority("ADMIN", "SENSEI", "STUDENT")
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .apply(corsConfigurer()); // Apply CORS configuration


        return http.build();
    }

    private CorsConfigurer<HttpSecurity> corsConfigurer() {
        return new CorsConfigurer<>();
    }
}
