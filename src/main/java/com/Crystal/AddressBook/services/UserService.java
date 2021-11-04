package com.Crystal.AddressBook.services;

import com.Crystal.AddressBook.models.User;


import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long username);
    User getUserByUsername(String username);
    User insertUser(User user);
    void updateUserPassword(Long id, User user);
    void deleteUser(Long id);
}
