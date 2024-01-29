package com.example.springboot.repository;

import com.example.springboot.model.User;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    Optional<User> findByUsername(String username);

    Optional<User> findUserByID(UUID id);

    Boolean existsByUsername(String username);
}
