package com.data.controller;

import com.data.DtoObjects.DemoFundsTransferDTO;
import com.data.entity.Page;
import com.data.entity.Transaction;
import com.data.service.ServiceInterfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account")
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
    public Transaction createNewTransaction(@RequestBody Transaction transaction) {
        return transactionService.createNewTransaction(transaction);
    }

    @GetMapping("/searchTransaction")
    public Transaction getTransactionById(int transactionId) {
        return transactionService.getTransactionById(transactionId);
    }
//the object should be an transaction with some information filled in,
// review this as the fields are transactionAccount for both sender and receiver, and it gives an error
    //TODO: constraint for
    @PostMapping("/transferFunds")
    public ResponseEntity transferFundsToAnotherAccount(@RequestBody DemoFundsTransferDTO transfer){
        String message= transactionService.transferFundsToAnotherAccount(transfer);
         return ResponseEntity.ok(message);
    }
}
