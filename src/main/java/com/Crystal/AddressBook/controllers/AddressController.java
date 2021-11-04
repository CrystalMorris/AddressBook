package com.Crystal.AddressBook.controllers;

import com.Crystal.AddressBook.models.Address;
import com.Crystal.AddressBook.services.AddressService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService= addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses(){
       List<Address> addresses = addressService.getAddresses();
       return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
    @GetMapping({"/{addressId}"})
    public ResponseEntity<Address> getAddress(@PathVariable Long addressId) {
        return new ResponseEntity<>(addressService.getAddressById(addressId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        Address address1 = addressService.insertAddress(address);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("address", "/addresses" + address1.getId().toString());
        return new ResponseEntity<>(address1, httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping({"/{addressId}"})
    public ResponseEntity<Address> updateAddress(@PathVariable("addressId") Long addressId,
                                                 @RequestBody Address address) {
        addressService.updateAddress(addressId,address);
        return new ResponseEntity<>(addressService.getAddressById(addressId), HttpStatus.OK);
    }
    @DeleteMapping({"/{addressId}"})
    public ResponseEntity<Address> deleteAddress(@PathVariable("addressId") Long addressId) {
        addressService.deleteAddress(addressId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
