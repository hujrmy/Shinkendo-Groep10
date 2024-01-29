package com.example.springboot.config;

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
                        req.requestMatchers("/api/v1/auth/authenticate").permitAll()
                                .requestMatchers(GET, "api/userExercises/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(POST, "api/v1/auth/register").hasAnyAuthority("SENSEI")
                                .requestMatchers(GET, "api/attendanceList").hasAnyAuthority("SENSEI")
                                .requestMatchers(GET, "api/attendanceList/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(PUT, "api/attendanceList/**").hasAnyAuthority("SENSEI")
                                .requestMatchers(POST, "api/attendanceList").hasAnyAuthority("SENSEI")
                                .requestMatchers(POST, "api/curriculum").hasAnyAuthority("SENSEI")
                                .requestMatchers(GET, "api/curriculum").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(POST, "api/dojo").hasAnyAuthority("SENSEI")
                                .requestMatchers(GET, "api/dojo").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(POST, "api/lesson").hasAnyAuthority("SENSEI")
                                .requestMatchers(DELETE, "api/curriculum/{curriculumId}").hasAnyAuthority("SENSEI")
                                .requestMatchers(GET, "/api/attendanceList/**").hasAnyAuthority("SENSEI")
                                .requestMatchers(POST, "/api/attendanceList/**").hasAnyAuthority("SENSEI")
                                .requestMatchers(PUT, "/api/attendanceList/**").hasAnyAuthority("SENSEI")
                                .requestMatchers(DELETE, "/api/attendanceList/**").hasAnyAuthority("SENSEI")
                                .requestMatchers(GET, "api/curriculumExercises").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(POST, "api/curriculumExercises").hasAnyAuthority("SENSEI")
                                .requestMatchers(POST, "api/curriculumExercises/**").hasAnyAuthority("SENSEI")
                                .requestMatchers(GET, "/api/exercise/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(POST, "api/exercise").hasAnyAuthority("SENSEI")
                                .requestMatchers(PUT, "/api/exercise/**").hasAuthority("SENSEI")
                                .requestMatchers(DELETE, "/api/exercise/**").hasAuthority("SENSEI")
                                .requestMatchers(GET, "/api/lesson/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(POST, "/api/lesson/**").hasAuthority("SENSEI")
                                .requestMatchers(DELETE, "/api/lesson/**").hasAuthority("SENSEI")
                                .requestMatchers(GET, "/api/note/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(POST, "/api/note/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(DELETE, "/api/note/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers("/api/post/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(GET, "/api/users/allNames").hasAuthority("SENSEI")
                                .requestMatchers(GET, "/api/users/names").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(GET, "/api/users/rights").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(GET, "/api/users").hasAuthority("SENSEI")
                                .requestMatchers(POST, "/api/users").hasAuthority("SENSEI")
                                .requestMatchers(DELETE, "/api/users/**").hasAuthority("SENSEI")
                                .requestMatchers(PUT, "/api/users/**").hasAuthority("SENSEI")
                                .requestMatchers(GET, "/api/users/find/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(GET, "/api/userExercises/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(POST, "/api/userExercises/**").hasAnyAuthority("SENSEI", "STUDENT")
                                .requestMatchers(DELETE, "/api/userExercises/**").hasAnyAuthority("SENSEI")
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
