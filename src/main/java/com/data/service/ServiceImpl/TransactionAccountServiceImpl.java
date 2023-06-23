package com.data.service.ServiceImpl;

import com.data.dao.implementation.TransactionAccountDaoImpl;
import com.data.entity.TransactionAccount;
import com.data.service.ServiceInterfaces.TransactionAccountService;
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
