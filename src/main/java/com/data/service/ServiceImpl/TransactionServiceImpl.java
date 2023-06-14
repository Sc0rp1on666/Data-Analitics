package com.data.service.ServiceImpl;

import com.data.DtoObjects.DemoFundsTransferDTO;
import com.data.dao.implementation.AccountDaoImpl;
import com.data.dao.implementation.TransactionAccountDaoImpl;
import com.data.dao.implementation.TransactionDaoImpl;
import com.data.entity.Page;
import com.data.entity.Transaction;
import com.data.entity.TransactionAccount;
import com.data.service.ServiceInterfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String transferFundsToAnotherAccount(DemoFundsTransferDTO transfer) {
        //first get the account from which funds are retrieved,
        TransactionAccount senderAccount = transactionAccountDao.getById(transfer.getSenderAccount());
        TransactionAccount receiverAccount = transactionAccountDao.getById(transfer.getReceiverAccount());
        Transaction transaction= new Transaction();
        String message="Empty";
        //add a failed transaction to DB,
        if(transfer.getTransactionAmount()>senderAccount.getAccountAmount()) message="Warning insufficient Funds, transaction is declined";
        else{
            transactionAccountDao.withdrawMoney(transfer.getTransactionAmount(),senderAccount.getTransactionAccountId());
            transactionAccountDao.depositMoney(transfer.getTransactionAmount(),receiverAccount.getTransactionAccountId());
            transaction.setTransactionAmount(transfer.getTransactionAmount());
            transaction.setSenderAccount(senderAccount);
            transaction.setReceiverAccount(receiverAccount);
            transaction.setTransactionStatus("CREATED");
            transaction.setTransactionType(transfer.getTransactionType());
            transactionDao.create(transaction);
            message="Transaction was successful current amount="+ transactionAccountDao.retrieveAccountAmount(senderAccount.getTransactionAccountId());;
        } return message;
    }
}
