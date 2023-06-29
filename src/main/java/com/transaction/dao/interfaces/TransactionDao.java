package com.transaction.dao.interfaces;

import com.transaction.entity.Transaction;

import java.util.List;

public interface TransactionDao extends GenericOperation<Transaction>{
    public List<Transaction> getTransactionHistoryByTransactionAccount(int transactionAccountId);

}
