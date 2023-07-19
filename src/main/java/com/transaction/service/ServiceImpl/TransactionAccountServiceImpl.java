package com.transaction.service.ServiceImpl;

import com.transaction.dao.implementation.TransactionAccountDaoImpl;
import com.transaction.entity.TransactionAccount;
import com.transaction.service.ServiceInterfaces.TransactionAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionAccountServiceImpl implements TransactionAccountService {
    @Autowired
    TransactionAccountDaoImpl transactionAccountDao;

    @Override
    public TransactionAccount getTransactionAccount(int transactionAccountId) {
        return transactionAccountDao.getById(transactionAccountId);
    }

    public List<TransactionAccount> getCardInformation(int accountId){
        return transactionAccountDao.getCardInformation(accountId);
    }
    public TransactionAccount getTransactionAccountByCardNumber(long cardNumber){
        return transactionAccountDao.getTransactionAccountByCardNumber(cardNumber);
    }

    public Boolean verifyAccountIsBankRegisteredByCardNumber(long cardNumber){
        return transactionAccountDao.verifyAccountIsBankRegisteredByCardNumber(cardNumber);
    }

    public Boolean verifyAccountIsBankRegistered(int accountId){
        return transactionAccountDao.verifyAccountIsBankRegistered(accountId);
    }
}
