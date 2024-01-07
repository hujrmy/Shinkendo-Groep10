package com.example.springboot.config;

import com.example.springboot.model.User;
import com.example.springboot.model.Rights;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.springboot.model.Rights.ADMIN;
import static com.example.springboot.model.Rights.SENSEI;
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
                        req.requestMatchers("/api/v1/auth/**")
                                .permitAll()
                                .requestMatchers(GET, "api/attendanceList").hasAnyAuthority("ROLE_SENSEI", "ROLE_ADMIN")
                                .requestMatchers(POST, "api/attendanceList").hasAnyAuthority("ROLE_SENSEI", "ROLE_ADMIN")
                                .requestMatchers(POST, "api/curriculum").hasAnyAuthority("ROLE_SENSEI", "ROLE_ADMIN")
                                .requestMatchers(POST, "api/dojo").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers(POST, "api/exercise").hasAnyAuthority("ROLE_SENSEI", "ROLE_ADMIN")
                                .requestMatchers(POST, "api/lesson").hasAnyAuthority("ROLE_SENSEI", "ROLE_ADMIN")
                                .requestMatchers(DELETE, "api/curriculum/{curriculumId}").hasAnyAuthority("ROLE_ADMIN")
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }
}
