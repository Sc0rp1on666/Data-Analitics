package com.data.service.ServiceImpl;

import com.data.DtoObjects.FundsTransferDTO;
import com.data.dao.implementation.AccountDaoImpl;
import com.data.dao.implementation.TransactionAccountDaoImpl;
import com.data.dao.implementation.TransactionDaoImpl;
import com.data.entity.Account;
import com.data.entity.Page;
import com.data.entity.Transaction;
import com.data.entity.TransactionAccount;
import com.data.service.ServiceInterfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDaoImpl transactionDao;
    @Autowired
    private AccountDaoImpl accountDao;
    @Autowired
    private TransactionAccountDaoImpl transactionAccountDao;

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

    @Override
    public void transferFundsToAnotherAccount(Transaction transaction) {
      List<Account> senderAccount= accountDao.getUserAccount(transaction.getSenderAccount().getAccountId());
       TransactionAccount transactionAccount= transactionAccountDao.getTransactionAccountByCardNumber(transaction.getReceiverAccount().getCardNumber());

    }
}
