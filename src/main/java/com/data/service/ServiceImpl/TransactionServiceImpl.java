package com.data.service.ServiceImpl;

import com.data.dao.implementation.AccountDaoImpl;
import com.data.dao.implementation.CurrencyDaoImpl;
import com.data.dao.implementation.TransactionAccountDaoImpl;
import com.data.dao.implementation.TransactionDaoImpl;
import com.data.entity.*;
import com.data.service.ServiceInterfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Objects;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDaoImpl transactionDao;
    @Autowired
    private AccountDaoImpl accountDao;
    @Autowired
    private TransactionAccountDaoImpl transactionAccountDao;
    @Autowired
    private CurrencyDaoImpl currencyDao;

    @Override
    public Page<Transaction> getPagedTransactions(int elementsPerPage, int pageIndex) {
        return new Page<>(transactionDao.getListOfRecords(elementsPerPage,pageIndex),transactionDao.countAllRecords(),pageIndex,elementsPerPage);
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


    public Transaction withdrawMoneyForExchange(Transaction transfer){
        return null;
    }

    public Transaction convertAmountToAnotherCurrency(Transaction transfer){
            Account senderAccount= accountDao.getById(transfer.getSenderAccount().getAccountId());
            Account recieverAccount= accountDao.getById(transfer.getReceiverAccount().getAccountId());
            String conversionPair= senderAccount.getAccountCurrencyType()+recieverAccount.getAccountCurrencyType();
            Currency currency= currencyDao.getConversionPair(conversionPair);
            double convertedAmount = transfer.getTransactionAmount()*currency.getConversionRate();
            transactionDao.create(transfer);
            transfer.setCurrencyType(conversionPair);
            transfer.setTransactionType("EXCHANGE");
            transfer.setTransactionAmount(convertedAmount);
            transactionDao.create(transfer);
            transfer.setTransactionType("TRANSFER");
            transfer.setCurrencyType(recieverAccount.getAccountCurrencyType());
            return transfer;
    }

    public Boolean cardRecordCheck(long cardNumber){
        return transactionAccountDao.getTransactionAccountByCardNumber(cardNumber)!=null;
    }

    @Override
    public String transferFundsToAnotherAccount(Transaction transfer) {
        Account senderAccount = accountDao.getById(transfer.getSenderAccount().getAccountId());
        //TODO: java input validation, spring input validation
        if(transfer.getTransactionAmount() == 0.00){transfer.setReasonMessage("Please provide proper transfer amount"); return transfer.getReasonMessage();}
        if(!cardRecordCheck(transfer.getReceiverAccount().getCardNumber())){transfer.setTransactionType("The provided Card Number is invalid or doesn't exist"); return transfer.getReasonMessage();}
        TransactionAccount receiverTransactionAccount= transactionAccountDao.getTransactionAccountByCardNumber(transfer.getReceiverAccount().getCardNumber());
        Account receiverAccount = accountDao.getById(receiverTransactionAccount.getAccountId());
        if(!Objects.equals(senderAccount.getAccountCurrencyType(), receiverAccount.getAccountCurrencyType())) convertAmountToAnotherCurrency(transfer);
        if(transfer.getTransactionAmount()>senderAccount.getAccountAmount())
        {
            transfer.setReasonMessage("Warning insufficient Funds, transaction is declined");
            transfer.setTransactionStatus("REJECTED");
        }
        else{
            accountDao.withdrawMoney(transfer.getTransactionAmount(),senderAccount.getAccountId());
            accountDao.depositMoney(transfer.getTransactionAmount(),receiverAccount.getAccountId());
            transfer.setTransactionStatus("CREATED");
            transfer.setReasonMessage("Transaction was successful current amount="+ accountDao.retrieveAccountAmount(senderAccount.getAccountId()));
        }
        transfer.setReceiverAccount(transactionAccountDao.getById(receiverAccount.getAccountId()));
        transfer.setSenderAccount(transactionAccountDao.getById(senderAccount.getAccountId()));
        transactionDao.create(transfer);
        return transfer.getReasonMessage();
    }
}
