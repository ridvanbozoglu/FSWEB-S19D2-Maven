package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @GetMapping("{id}")
    public Address findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @PostMapping
    public Address saveAddress(@RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id){
        return addressService.update(id);
    }

    @DeleteMapping("/{id}")
    public Address deleteAddress(@PathVariable Long id){
        return addressService.delete(id);
    }




}
