package com.transaction.dao.interfaces;

import com.transaction.entity.TransactionAccount;

import java.util.List;

public interface TransactionAccountDao extends GenericOperation<TransactionAccount> {

    List<TransactionAccount> getAccountTransactionAccounts(int accountId);

    TransactionAccount getTransactionAccountByAccountId(int accountId);

    TransactionAccount getTransactionAccountByCardNumber(long cardNumber);

     List<TransactionAccount> getCardInformation(int accountId);
}
