package com.Crystal.AddressBook.bootstrap;


import com.Crystal.AddressBook.models.User;
import com.Crystal.AddressBook.models.UserRole;
import com.Crystal.AddressBook.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                        .password("$2a$12$jgFk/pQbnCT4LnvN20MEdenoVj7xadnmHbw4RbFUynEp9H6Iyv7Sm")
                        .role(UserRole.ADMIN)
                    .build()
            );

            userRepository.save(

                    User.builder()
                            .username("skyDancer")
                            .password("$2a$12$JVF.hh.GIMq7tZEjzyskg.OEliNDH9GImHwk5NzkAmmgCWGalTSWi")
                            .role(UserRole.USER)
                            .build()
            );

        }
        System.out.println("Sample Users Loaded");
    }

}
