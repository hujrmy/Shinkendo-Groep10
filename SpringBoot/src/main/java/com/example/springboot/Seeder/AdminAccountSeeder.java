package com.example.springboot.Seeder;

import com.example.springboot.dao.AuthenticationDao;
import com.example.springboot.model.Dojo;
import com.example.springboot.model.Enums.Rank;
import com.example.springboot.model.Enums.Rights;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AdminAccountSeeder {

    @Autowired
    private AuthenticationDao authenticationDao;

    public User seed(Dojo dojo){
        User user = new User();
        user.setID(UUID.randomUUID());
        user.setRights(Rights.SENSEI);
        user.setName("Sensei");
        user.setUsername("Sensei");
        user.setPassword("Groente123");
        user.setDojo(dojo);
        user.setRank(Rank.Hyaku);
        this.authenticationDao.register(user);
        return user;
    }
}
