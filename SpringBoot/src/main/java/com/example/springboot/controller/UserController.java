package com.example.springboot.controller;

import com.example.springboot.dao.UserDao;
import com.example.springboot.model.ApiResponse;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserDao userDao;
    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse getAllUsers(){
        return new ApiResponse(HttpStatus.ACCEPTED, this.userDao.getAllUsers());
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse addUsers(@RequestBody User newDao){
        User comment = this.userDao.addUsers(newDao);
        return new ApiResponse(HttpStatus.ACCEPTED, comment);
    }



//    @PostMapping("/validate")
//    public ResponseEntity<String> validateUser(@RequestBody Map<String, String> request) {
//        String username = request.get("username");
//        String password = request.get("password");
//        System.out.println("Username: " + username + " Password: " + password);
//
//
//        User user = userRepository.findByUsername(username);
////        System.out.println(user.getPassword());
//
//        if (user != null && password.equals(user.getPassword())) {
//            return new ResponseEntity<>("Valid credentials", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
//        }
//    }


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
