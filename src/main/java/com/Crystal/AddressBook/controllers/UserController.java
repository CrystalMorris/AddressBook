package com.Crystal.AddressBook.controllers;




import com.Crystal.AddressBook.models.User;

import com.Crystal.AddressBook.services.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;

    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping({"/{userId}"})
    public ResponseEntity<User> getUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){
        return new ResponseEntity<>(userService.getUserByUsername(username),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User user1 = userService.insertUser(user);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("user", "/users" + user1.getId().toString());
        return new ResponseEntity<>(user1, httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping({"/{userId}"})
    public ResponseEntity<User> updateUserPassword(@PathVariable("userId") Long userId,
                                                 @RequestBody User user) {
        userService.updateUserPassword(userId,user);
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
    @PutMapping({"/user/{username}"})
    public ResponseEntity<User> updateUserPassword(@PathVariable("username") String username, @RequestBody User user){
        User thisUser = userService.getUserByUsername(username);
        userService.updateUserPassword(thisUser.getId(), user);
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }
    @DeleteMapping({"/{userId}"})
    public ResponseEntity<User> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
