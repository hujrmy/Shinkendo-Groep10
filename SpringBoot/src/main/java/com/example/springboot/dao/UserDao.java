package com.example.springboot.dao;

import com.example.springboot.model.*;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

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

    public List<String> getUsersByUsername(String username) {
        List<String> usersList = new ArrayList<>();
        List<User> users = this.userRepository.findAll();

        for (User user : users) {
            if(Objects.equals(user.getUsername(), username)){
                usersList.add(user.getUsername());
            }
        }
        return usersList;
    }

    public List<Rights> getRightsByUserName(String username){
        List<Rights> usersList = new ArrayList<>();
        List<User> users = this.userRepository.findAll();

        for (User user : users) {
            if(Objects.equals(user.getUsername(), username)){
                usersList.add(user.getRights());
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

    public User findUserById(UUID id){
        return userRepository.findUserByID(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }



    public User updateUser(long userId, Rights newRights, String newName, String newUsername, String newPassword, Dojo newDojo, Rank newRank) {
        Optional<User> userOptional = userRepository.findById((int) userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(newName);
            user.setUsername(newUsername);
            user.setRights(newRights);
            user.setDojo(newDojo);
            user.setRank(newRank);
            user = userRepository.save(user);
            return user;
        }
        return null;
    }

}
