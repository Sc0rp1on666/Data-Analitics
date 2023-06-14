package com.data.dao.interfaces;

import com.data.entity.TransactionAccount;

import java.util.List;

public interface TransactionAccountDao extends GenericOperation<TransactionAccount> {

    public List<TransactionAccount> getAccountTransactionAccounts(int accountId);

    public void depositMoney(double operationAmount, int transactionAccountId);

    public void withdrawMoney(double operationAmount, int transactionAccountId);
}
