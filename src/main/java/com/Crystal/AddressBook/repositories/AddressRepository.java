package com.Crystal.AddressBook.repositories;

import com.Crystal.AddressBook.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
