package com.data.dao.interfaces;

import com.data.entity.Transaction;
import com.data.entity.TransactionAccount;

import java.util.List;

public interface TransactionDao extends GenericOperation<Transaction>{
    public List<Transaction> getTransactionHistoryByTransactionAccount(int transactionAccountId);

}
