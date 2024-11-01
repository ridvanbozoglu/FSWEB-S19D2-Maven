package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.dto.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer find(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Bulunamadı"));
        return customer;
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    @Override
    public CustomerResponse update(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            return new CustomerResponse(customer.getId(),customer.getFirstName(), customer.getSalary());
        }else throw new RuntimeException("id ile bulunamadı!");
    }

    @Transactional
    @Override
    public Customer delete(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()){
            customerRepository.delete(optionalCustomer.get());
            return optionalCustomer.get();
        }else return null;
    }
}
