package com.example.springboot.repository;

import com.example.springboot.model.Enums.Rights;
import com.example.springboot.model.User;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    Optional<User> findByUsername(String username);

    Optional<User> findUserByID(UUID id);

    Boolean existsByUsername(String username);

    @Query("SELECT u.rights FROM User u WHERE u.ID = :id")
    Optional<Rights> findRightsById(@Param("id") UUID id);

}
