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

    public boolean deleteUserExercises(UUID userExercisesId){
        if(userExercisesRepository.existsByID(userExercisesId)) {
            userExercisesRepository.deleteByID(userExercisesId);
            return true;
        }
        return false;
    }

    public List<Object[]> findUserExercisesByUsername(UUID userId) {
        return userExercisesRepository.findUserExercises(userId);
    }

    public int updateToDo(UUID userId, UUID exercise_id) {
        int update = userExercisesRepository.updateToDoList(userId, exercise_id);
        userExercisesRepository.updateLastDone(userId, exercise_id);
        return update;
    }
}
