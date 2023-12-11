package com.example.springboot.dao;

import com.example.springboot.Exception.UsernameAlreadyExistsException;
import com.example.springboot.model.AuthenticationRequest;
import com.example.springboot.model.AuthenticationResponse;
import com.example.springboot.model.RegisterRequest;
import com.example.springboot.config.JwtService;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationDao {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {

        if (repository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already exists.");
        }

        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .rank(request.getRank())
                .dojo(request.getDojo())
                .rights(request.getRights())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public void  refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userName;
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userName = jwtService.extractUsername(refreshToken);
        if (userName != null) {
            var user  = this.repository.findByUsername(userName).
                    orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accesToken = jwtService.generateToken(user);
                var authResponse = AuthenticationResponse.builder()
                        .token(accesToken)
                        .refreshToken(refreshToken)
                         .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }

    }
}
