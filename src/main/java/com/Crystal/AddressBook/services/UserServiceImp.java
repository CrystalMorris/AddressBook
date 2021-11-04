package com.Crystal.AddressBook.services;


import com.Crystal.AddressBook.models.User;
import com.Crystal.AddressBook.repositories.UserRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImp implements UserService {

    UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
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
       userToUpdate.setPassword(user.getPassword());
       userRepository.save(userToUpdate);
    }
    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }


    public void deleteUser(Long id ){
        userRepository.deleteById(id);
    }


}
