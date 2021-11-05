package com.Crystal.AddressBook.bootstrap;


import com.Crystal.AddressBook.models.User;
import com.Crystal.AddressBook.models.UserRole;
import com.Crystal.AddressBook.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class UserLoader implements CommandLineRunner {

    public final UserRepository userRepository;

    public UserLoader(UserRepository userRepository){

        this.userRepository = userRepository;

    }
    @Override
    public void run(String...args) throws Exception {
        loadUsers();
    }

    private void loadUsers(){
        PasswordEncoder passwordEncoder;
        int strength = 12;
        passwordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        if(userRepository.count() == 0){

            userRepository.save(
                    User.builder()
                        .username("sparky")
                        .password(passwordEncoder.encode("roadIslandPickle"))
                        .role(UserRole.ADMIN)
                    .build()
            );

            userRepository.save(

                    User.builder()
                            .username("skyDancer")
                            .password(passwordEncoder.encode("stupidPw"))
                            .role(UserRole.USER)
                            .build()
            );

        }
        System.out.println("Sample Users Loaded");
    }

}
