package com.workintech.s18d4.service;


import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    Customer find(Long id);

    Customer save(Customer customer);

    CustomerResponse update(Long id);

    Customer delete(Long id);

    List<Customer> findAll();
}
