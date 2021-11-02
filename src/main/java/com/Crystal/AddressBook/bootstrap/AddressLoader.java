package com.Crystal.AddressBook.bootstrap;

import com.Crystal.AddressBook.models.Address;
import com.Crystal.AddressBook.repositories.AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AddressLoader implements CommandLineRunner {
    public final AddressRepository addressRepository;

    public AddressLoader(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadAddresses();
    }

    private void loadAddresses() {
        if (addressRepository.count() == 0) {
            addressRepository.save(
                    Address.builder()
                            .firstName("John")
                            .lastName("Doe")
                            .number("123")
                            .street("Oak Lane")
                            .unit("")
                            .city("Sometown")
                            .state("MO")
                            .postalCode("12345")
                            .email("johndoe@nomail.com")
                            .cellPhone("1112223333")
                            .workPhone("2223337896")
                            .homePhone("4447778888")
                            .build()
            );
            addressRepository.save(
                    Address.builder()
                            .firstName("Allen")
                            .lastName("Smith")
                            .number("896")
                            .street("Main St")
                            .unit("3b")
                            .city("Big City")
                            .state("AZ")
                            .postalCode("89674")
                            .email("Smith.allen@lotsomail.com")
                            .cellPhone("8967564123")
                            .workPhone("8964123576")
                            .homePhone("8967414526")
                            .build()
            );

            System.out.println("Sample Addresses Loaded");
        }
    }
}