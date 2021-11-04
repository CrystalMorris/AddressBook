package com.Crystal.AddressBook.services;

import com.Crystal.AddressBook.models.Address;
import com.Crystal.AddressBook.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImp implements AddressService{
    AddressRepository addressRepository;

    public AddressServiceImp(AddressRepository addressRepository){

        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAddresses(){
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;

    }

    @Override
    public Address getAddressById(Long id){
        return addressRepository.findById(id).get();
    }

    @Override
    public Address insertAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void updateAddress(Long id, Address address) {
        Address addressFromDb = addressRepository.findById(id).get();
        System.out.println(addressFromDb.toString());
        addressFromDb.setFirstName(address.getFirstName());
        addressFromDb.setLastName(address.getLastName());
        addressFromDb.setNumber(address.getNumber());
        addressFromDb.setStreet(address.getStreet());
        addressFromDb.setCity(address.getCity());
        addressFromDb.setState(address.getState());
        addressFromDb.setPostalCode(address.getPostalCode());
        addressFromDb.setCellPhone(address.getCellPhone());
        addressFromDb.setWorkPhone(address.getWorkPhone());
        addressFromDb.setHomePhone(address.getHomePhone());
        addressRepository.save(addressFromDb);

    }
    @Override
    public void deleteAddress(Long addressId){
        addressRepository.deleteById(addressId);
    }
}
