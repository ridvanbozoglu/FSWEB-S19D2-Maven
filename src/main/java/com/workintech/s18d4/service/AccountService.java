package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.dto.AccountResponse;

import java.util.List;

public interface AccountService {


    List<Account> findAll();

    Account find(Long id);

    Account save(Account account);

    AccountResponse update(Long customerId, Account account);

    Account delete(Long id);

}
