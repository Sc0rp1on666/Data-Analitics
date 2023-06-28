package com.data.controller;

import com.data.entity.Account;
import com.data.entity.Page;
import com.data.service.ServiceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    //TODO: don't forget to remake this, as it should be a DTO containing Account and User in one package(think about privileges how it should be assigned)
    @PostMapping
    Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/listOfUserAccounts")
    public Page<Account> getPagedAccounts(@RequestParam("pageIndex") int pageIndex,
                                          @RequestParam("elementsPerPage") int elementsPerPage){
        return accountService.getPagedAccount(elementsPerPage,pageIndex);
    }
    //TODO: remake this, make it search by userId, list of accounts based on user(can have several account in different currency and transactions)
    @GetMapping("/getById")
    //TODO: make sure that logged user can have access only to his account
    public List<Account> getAccountById(@RequestParam("userId")int userId){
        return accountService.getAccountById(userId);
    }
}