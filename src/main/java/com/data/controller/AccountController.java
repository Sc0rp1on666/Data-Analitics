package com.data.controller;

import com.data.entity.Account;
import com.data.entity.Page;
import com.data.service.ServiceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pagedAccounts")
    public Page<Account> getPagedAccounts(@RequestParam("pageIndex") int pageIndex,
                                          @RequestParam("elementsPerPage") int elementsPerPage){
        return accountService.getPagedAccount(pageIndex,elementsPerPage);
    }
    //TODO: remake this, make it search by IDNP or smth else
    @GetMapping("/getById")
    public Account getAccountById(@RequestParam("accountId")int accountId){
        return accountService.getAccountById(accountId);
    }
}