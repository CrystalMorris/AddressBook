package com.Crystal.AddressBook.bootstrap;


import com.Crystal.AddressBook.models.User;
import com.Crystal.AddressBook.models.UserRole;
import com.Crystal.AddressBook.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        if(userRepository.count() == 0){
            userRepository.save(
                    User.builder()
                        .username("sparky")
                        .password("roadIslandpIckles")
                        .userRole(UserRole.ADMIN)
                    .build()
            );
            userRepository.save(
                    User.builder()
                            .username("skyDancer")
                            .password("free456wind")
                            .userRole(UserRole.USER_ROLE)
                            .build()
            );

        }
        System.out.println("Sample Users Loaded");
    }

}
