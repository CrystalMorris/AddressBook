package com.Crystal.AddressBook.repositories;

import com.Crystal.AddressBook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface UserRepository extends CrudRepository<User, Long> {
//     List<User> findByUsername(String username);
//    // List<User> findByUserRole(String role);
//
//
//}
public interface UserRepository extends JpaRepository<User, Long> {
     User findByUsername(String username);
     // List<User> findByUserRole(String role);


}