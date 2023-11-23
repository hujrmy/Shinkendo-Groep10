package com.example.springboot.dao;

import com.example.springboot.model.Curriculum;
import com.example.springboot.model.Rights;
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

    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        return users;
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

    public List<String> getAllUserData(){
        List<String> userData = new ArrayList<>();
        List<User> users = this.userRepository.findAll();

        for(User user : users){
            userData.add(user.getName());
            userData.add(String.valueOf(user.getID()));
            userData.add(String.valueOf(user.getUsername()));
            userData.add(user.getRights().toString());
        }
        return userData;
    }


    public boolean deleteUser(long userId) {
        if (userRepository.existsById((int) userId)) {
            userRepository.deleteById((int) userId);
            return true;
        }
        return false;
    }
}
