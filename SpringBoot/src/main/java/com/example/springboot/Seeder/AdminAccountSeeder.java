package com.example.springboot.Seeder;

import com.example.springboot.dao.AuthenticationDao;
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
    private AuthenticationDao authenticationDao;

    public User seed(Dojo dojo){
        User user = new User();
        user.setID(1);
        user.setRights(Rights.SENSEI);
        user.setName("admin");
        user.setUsername("admin");
        user.setPassword("Groente123");
        user.setDojo(dojo);
        user.setRank(Rank.IKKYU);
        this.authenticationDao.register(user);
        return user;
    }
}
