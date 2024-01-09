package com.example.springboot.Seeder;

import com.example.springboot.dao.*;
import com.example.springboot.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cglib.core.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Component
public class UserExercisesSeeder {

    @Autowired
    private UserExercisesDao userExercisesDao;

    public void seed(User user){
        for (int j = 0; j < 10; j++) {
            UserExercises userExercises = new UserExercises();
            userExercises.setUser(user);
            userExercises.setExerciseToDo(10);
            userExercises.setExerciseDone(0);
            userExercises.setLastDone(LocalDate.now());
            this.userExercisesDao.addUserExercises(userExercises);
        }
    }
}
