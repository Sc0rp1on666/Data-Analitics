package com.transaction.controller;

import com.transaction.entity.Account;
import com.transaction.entity.Page;
import com.transaction.service.ServiceImpl.AccountServiceImpl;
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
    @GetMapping("/getListOfAccountsById")
    //TODO: make sure that logged user can have access only to his account
    public List<Account> getListOfAccountsById(@RequestParam("userId")int userId){
        return accountService.getListOfAccountsById(userId);
    }

    public Account getAccountById(@RequestParam("accountId")int accountId){
        return accountService.getAccountByID(accountId);
    }

    @GetMapping("/withdrawMoneyFromAccount")
    public void withdrawMoneyFromAccount(@RequestParam("amount") double amount,
                                         @RequestParam("accountId") int accountId){
        accountService.withdrawMoneyFromAccount(amount,accountId);
    }

    @GetMapping("/depositMoneyToAccount")
    public void depositMoneyToAccount(@RequestParam("amount") double amount,
                                      @RequestParam("accountId")int accountId){
        accountService.depositMoneyToAccount(amount, accountId);
    }
}