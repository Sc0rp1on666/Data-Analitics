package com.data.service.ServiceInterfaces;

import com.data.entity.Page;
import com.data.entity.Transaction;

public interface TransactionService {
    public Page<Transaction> getPagedTransactions(int elementsPerPage,int pageIndex);

    public Transaction getTransactionById(int transactionId);

    public Page<Transaction> getTransactionHistoryByTransactionAccount(int transactionAccountId, int elementsPerPage, int pageIndex);

    public Transaction createNewTransaction(Transaction transaction);

}
