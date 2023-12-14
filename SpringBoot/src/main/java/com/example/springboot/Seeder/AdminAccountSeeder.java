package com.example.springboot.Seeder;

import com.example.springboot.dao.UserDao;
import com.example.springboot.model.Dojo;
import com.example.springboot.model.Rank;
import com.example.springboot.model.Rights;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminAccountSeeder {

    @Autowired
    private UserDao userDao;

    public void seed(Dojo dojo){
        User user = new User();
        user.setID(1);
        user.setRights(Rights.ADMIN);
        user.setName("admin");
        user.setUsername("admin");
        user.setPassword("$2a$10$NvMn565mDZjpNsYs6P66fehsLKaeJYFgYDZX5eCAEPVvwnJO6eeBK");
        user.setDojo(dojo);
        user.setRank(Rank.IKKYU);
        this.userDao.addUsers(user);
    }
}
