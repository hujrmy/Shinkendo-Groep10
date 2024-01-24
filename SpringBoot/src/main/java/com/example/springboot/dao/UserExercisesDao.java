package com.example.springboot.dao;

import com.example.springboot.model.UserExercises;
import com.example.springboot.repository.UserExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserExercisesDao {

    @Autowired
    private UserExercisesRepository userExercisesRepository;

    public UserExercisesDao(UserExercisesRepository userExercisesRepository) {
        this.userExercisesRepository = userExercisesRepository;
    }

    public UserExercises addUserExercises(UserExercises newUserExercises){
        UserExercises userExercises = this.userExercisesRepository.save(newUserExercises);
        return userExercises;
    }

    public ArrayList<UserExercises> getAllUserExercises(){
        ArrayList<UserExercises> userExercises = (ArrayList<UserExercises>) this.userExercisesRepository.findAll();
        return userExercises;
    }

    public boolean deleteUserExercises(long userExercisesId){
        if(userExercisesRepository.existsById((int) userExercisesId)) {
            userExercisesRepository.deleteById((int) userExercisesId);
            return true;
        }
        return false;
    }

    public List<Object[]> findUserExercisesByUsername(String username) {
        return userExercisesRepository.findUserExercises(username);
    }

    public int updateToDo(String username, int exercise_id) {
        int update = userExercisesRepository.updateToDoList(username, exercise_id);
        userExercisesRepository.updateLastDone(username, exercise_id);
        return update;
    }
}
