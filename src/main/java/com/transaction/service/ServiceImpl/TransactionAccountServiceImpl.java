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
}
