package com.data.service.ServiceInterfaces;

import com.data.entity.TransactionAccount;

import java.util.List;

public interface TransactionAccountService {

     TransactionAccount getTransactionAccount(int transactionAccountId);

     List<TransactionAccount> getCardInformation(int accountId);

}
