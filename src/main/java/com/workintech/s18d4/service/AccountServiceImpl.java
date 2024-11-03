package com.workintech.s18d4.service;

import com.workintech.s18d4.repository.AccountRepository;
import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{


    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account find(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("bulunamadı!"));
        return account;
    }

    @Transactional
    @Override
    public Account save(Account account) {
        accountRepository.save(account);
        return account;
    }

    @Transactional
    @Override
    public AccountResponse update(Long customerId, Account account) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()){
            account.setCustomer(customerOptional.get());
            accountRepository.save(account);
            return new AccountResponse(customerId,account.getAccountName(),account.getMoneyAmount());
        } else return null;
    }

    @Transactional
    @Override
    public Account delete(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()){
            accountRepository.delete(accountOptional.get());
            return accountOptional.get();
        }else return null;
    }
}
