package com.data.service.ServiceInterfaces;

import com.data.DtoObjects.DemoFundsTransferDTO;
import com.data.entity.Page;
import com.data.entity.Transaction;

public interface TransactionService {
    Page<Transaction> getPagedTransactions(int elementsPerPage,int pageIndex);

    Transaction getTransactionById(int transactionId);

    Page<Transaction> getTransactionHistoryByTransactionAccount(int transactionAccountId, int elementsPerPage, int pageIndex);

    Transaction createNewTransaction(Transaction transaction);

    String transferFundsToAnotherAccount(DemoFundsTransferDTO transfer);
}
