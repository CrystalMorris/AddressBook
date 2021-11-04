package com.Crystal.AddressBook.services;


import com.Crystal.AddressBook.models.User;
import com.Crystal.AddressBook.repositories.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImp implements UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
     @Override
     public List<User> getUsers(){
         List<User> users = new ArrayList<>();
         userRepository.findAll().forEach(users::add);
         return users;
     }

    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username).get(0);
    }

    @Override
    public void updateUserPassword(Long id, User user){
       User userToUpdate = userRepository.findById(id).get();
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
       userToUpdate.setPassword(encodedPassword);
       userRepository.save(userToUpdate);
    }
    @Override
    public User insertUser(User user) {
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }


    public void deleteUser(Long id ){
        userRepository.deleteById(id);
    }


}
