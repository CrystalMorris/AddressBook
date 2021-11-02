package com.Crystal.AddressBook.services;

import com.Crystal.AddressBook.models.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddresses();
    Address getAddressById(Long id);
    Address insert(Address address);
    void updateAddress(Long id, Address address);
    void deleteAddress(Long addressId);
}
