package com.transaction.service.ServiceInterfaces;

import com.transaction.entity.TransactionAccount;

import java.util.List;

public interface TransactionAccountService {

     TransactionAccount getTransactionAccount(int transactionAccountId);

     List<TransactionAccount> getCardInformation(int accountId);

}
