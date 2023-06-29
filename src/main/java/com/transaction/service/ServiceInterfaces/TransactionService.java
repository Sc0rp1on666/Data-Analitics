package com.transaction.service.ServiceInterfaces;

import com.transaction.entity.Page;
import com.transaction.entity.Transaction;

public interface TransactionService {
    Page<Transaction> getPagedTransactions(int elementsPerPage,int pageIndex);

    Transaction getTransactionById(int transactionId);

    Page<Transaction> getTransactionHistoryByTransactionAccount(int transactionAccountId, int elementsPerPage, int pageIndex);

    Transaction createNewTransaction(Transaction transaction);
    String registerTransaction(Transaction transfer);
//    String transferFundsToAnotherAccount(DemoFundsTransferDTO transfer);
}
