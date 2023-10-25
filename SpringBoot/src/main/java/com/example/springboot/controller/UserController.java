package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/saveUser")
    public User saveUsername (@RequestBody User save) {
        return userRepository.save(save);
    }

    @GetMapping("/getUser")
    public Iterable<User> getUsername() {
        return userRepository.findAll();
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        System.out.println("Username: " + username + " Password: " + password);


        User user = userRepository.findByUsername(username);
//        System.out.println(user.getPassword());

        if (user != null && password.equals(user.getPassword())) {
            return new ResponseEntity<>("Valid credentials", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }


    /* //hier kan je waardes mee in de console printen, niet nodig maar kan later handig zijn om dingen te testen
    @GetMapping("/printColumnValues")
    public ResponseEntity<String> printColumnValues() {
        Iterable<User> users = userRepository.findAll();

        StringBuilder columnValues = new StringBuilder();

        for (User user : users) {
            System.out.println("sdasd" + user.getUsername());
            String username = user.getUsername();

            columnValues.append(username).append("\n");
        }

        System.out.println("Waarden van de kolom:");
        System.out.println(columnValues.toString());

        return new ResponseEntity<>("Waarden van de kolom afgedrukt in de console.", HttpStatus.OK);
    }
*/


}
