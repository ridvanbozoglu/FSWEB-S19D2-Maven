package com.workintech.s18d4.service;


import com.workintech.s18d4.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();

    Address findById(Long id);

    Address save(Address address);

    Address update(Long id);

    Address delete(Long id);
}
