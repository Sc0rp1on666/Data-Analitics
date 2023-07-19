package com.transaction.controller;

import com.transaction.entity.TransactionAccount;
import com.transaction.service.ServiceImpl.TransactionAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction-account")
public class TransactionAccountController {

    @Autowired
    TransactionAccountServiceImpl transactionAccountService;

    @GetMapping("/searchTransactionAccount")
    public TransactionAccount getTransactionAccountInfo(@RequestParam("transactionAccountId") int transactionAccountId){
        return transactionAccountService.getTransactionAccount(transactionAccountId);
    }

    @GetMapping("/cardInfo")
    public List<TransactionAccount> getCardInformation(@RequestParam("accountId") int accountId) {
        return transactionAccountService.getCardInformation(accountId);
    }

    @GetMapping("/getTransactionAccountByCardNumber")
    public TransactionAccount getTransactionAccountByCardNumber(@RequestParam("cardNumber") long cardNumber){
        return transactionAccountService.getTransactionAccountByCardNumber(cardNumber);
    }
    @GetMapping("/verifyAccountIsBankRegisteredByCardNumber")
    public Boolean verifyAccountIsBankRegisteredByCardNumber(@RequestParam("cardNumber") long cardNumber){
        return transactionAccountService.verifyAccountIsBankRegisteredByCardNumber(cardNumber);
    }
    @GetMapping("verifyAccountIsBankRegistered")
    public Boolean verifyAccountIsBankRegistered(@RequestParam("accountId") int accountId){
        return transactionAccountService.verifyAccountIsBankRegistered(accountId);
    }
}