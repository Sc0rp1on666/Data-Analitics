package com.data.controller;

import com.data.entity.TransactionAccount;
import com.data.service.ServiceImpl.TransactionAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactionAccount")
public class TransactionAccountController {
    @Autowired
    TransactionAccountServiceImpl transactionAccountService;

    @GetMapping("/searchTransactionAccount")
    public TransactionAccount getTransactionAccountInfo(@RequestParam("transactionAccountId") int transactionAccountId){
        return transactionAccountService.getTransactionAccount(transactionAccountId);
    }

        }
