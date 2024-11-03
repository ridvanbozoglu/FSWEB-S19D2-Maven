package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id){
        return accountService.find(id);
    }

    @PostMapping("/{id}")
    public Account saveAccount(@RequestBody Account account){
        return accountService.save(account);
    }

    @PutMapping("/{customerId}")
    public AccountResponse updateAccount(@PathVariable Long customerId,@RequestBody Account account ){
        return accountService.update(customerId,account);
    }

    @DeleteMapping("/{id}")
    public Account deleteAccount(@PathVariable Long id){
        Account account = accountService.find(id);
        return accountService.delete(id);
    }
}
