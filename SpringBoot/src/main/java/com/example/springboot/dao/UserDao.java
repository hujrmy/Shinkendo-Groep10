package com.example.springboot.dao;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    public User addUsers(User newUser) {
        User user = this.userRepository.save(newUser);
        return user;
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> allUsers = (ArrayList<User>) this.userRepository.findAll();
        return allUsers;
    }
}
