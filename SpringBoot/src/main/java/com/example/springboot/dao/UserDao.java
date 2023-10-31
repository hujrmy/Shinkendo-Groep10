package com.example.springboot.dao;

import com.example.springboot.model.Exercise;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    public User addUsers(User newUser) {
        User user = this.userRepository.save(newUser);
        return user;
    }

    public List<String> getAllUsers(){
        List<String> usersList = new ArrayList<>();
        List<User> users = this.userRepository.findAll();

        for (User user : users) {
            usersList.add(user.getName());
        }
        return usersList;
    }

    public List<String> getUsersByName(String name) {
        List<String> usersList = new ArrayList<>();
        List<User> users = this.userRepository.findAll();

        for (User user : users) {
            if(Objects.equals(user.getName(), name)){
                usersList.add(user.getName());
            }
        }
        return usersList;
    }

}
