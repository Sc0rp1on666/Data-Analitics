package com.data.service.ServiceImpl;

import com.data.dao.implementation.TransactionDaoImpl;
import com.data.entity.Page;
import com.data.entity.Transaction;
import com.data.service.ServiceInterfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDaoImpl transactionDao;
    @Override
    public Page<Transaction> getPagedTransactions(int elementsPerPage, int pageIndex) {
        return new Page<>(transactionDao.getListOfRecords(elementsPerPage,pageIndex),transactionDao.countAllRecords(),elementsPerPage,pageIndex);
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        return transactionDao.getById(transactionId);
    }

    @Override
    public Page<Transaction> getTransactionHistoryByTransactionAccount(int transactionAccountId, int elementsPerPage, int pageIndex) {
        return new Page<>(transactionDao.getTransactionHistoryByTransactionAccount(transactionAccountId),transactionDao.countAllRecords(), elementsPerPage,pageIndex );
    }

    @Override
    public Transaction createNewTransaction(Transaction transaction) {
       return transactionDao.create(transaction);
    }
}
