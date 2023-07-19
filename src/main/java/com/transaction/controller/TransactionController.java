package com.transaction.controller;

import com.transaction.entity.Page;
import com.transaction.entity.Transaction;
import com.transaction.service.ServiceInterfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/com/transaction")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction-list")
    public Page<Transaction> getPagedTransactions(@RequestParam("elementsPerPage") int elementsPerPage,
                                                  @RequestParam("pageIndex") int pageIndex) {
        return transactionService.getPagedTransactions(elementsPerPage, pageIndex);
    }

    @GetMapping("/transactionHistory")
    public Page<Transaction> getTransactionHistoryByTransactionAccount(@RequestParam("transactionAccountId") int transactionAccountId,
                                                                       @RequestParam("elementsPerPage") int elementsPerPage,
                                                                       @RequestParam("pageIndex") int pageIndex) {
        return transactionService.getTransactionHistoryByTransactionAccount(transactionAccountId, elementsPerPage, pageIndex);
    }


    @PostMapping("/newTransaction")
    public Transaction createNewTransaction( @RequestBody Transaction transaction) {
        return transactionService.createNewTransaction(transaction);
    }

    @GetMapping("/searchTransaction")
    public Transaction getTransactionById(int transactionId) {
        return transactionService.getTransactionById(transactionId);
    }

    //TODO: create a jar with all entity which will be imported in all project
    @PostMapping("/registerTransaction")
    public ResponseEntity registerTransaction(@Valid @RequestBody Transaction transfer, BindingResult result)
    {
        if(result.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please fill in the necessary fields");
        }
        String message= transactionService.registerTransaction(transfer);
        return ResponseEntity.ok(message);
    }
}
