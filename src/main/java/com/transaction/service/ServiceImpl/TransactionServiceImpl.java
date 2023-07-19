package com.transaction.service.ServiceImpl;

import com.transaction.dao.implementation.AccountDaoImpl;
import com.transaction.dao.implementation.CurrencyDaoImpl;
import com.transaction.dao.implementation.TransactionAccountDaoImpl;
import com.transaction.dao.implementation.TransactionDaoImpl;
import com.transaction.entity.*;
import com.transaction.service.ServiceInterfaces.TransactionAccountService;
import com.transaction.service.ServiceInterfaces.TransactionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class TransactionServiceImpl implements TransactionService {

    Logger logger = Logger.getLogger(TransactionAccountService.class);
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
        return new Page<>(transactionDao.getListOfRecords(elementsPerPage, pageIndex), transactionDao.countAllRecords(), pageIndex, elementsPerPage);
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        return transactionDao.getById(transactionId);
    }

    @Override
    public Page<Transaction> getTransactionHistoryByTransactionAccount(int transactionAccountId, int elementsPerPage, int pageIndex) {
        return new Page<>(transactionDao.getTransactionHistoryByTransactionAccount(transactionAccountId), transactionDao.countAllRecords(), elementsPerPage, pageIndex);
    }

    @Override
    public Transaction createNewTransaction(Transaction transaction) {
        return transactionDao.create(transaction);
    }


    public Transaction withdrawMoneyForExchange(Transaction transfer) {
        Account senderAccount = accountDao.getById(transfer.getSenderAccount().getAccountId());
        if (transfer.getTransactionAmount() > senderAccount.getAccountAmount()) {
            transfer.setTransactionType("WITHDRAW");
            transfer.setReasonMessage("Warning insufficient Funds, transaction is declined");
            transfer.setTransactionStatus(TransactionStatus.REJECTED.toString());
            transactionDao.create(transfer);
        } else {
            accountDao.withdrawMoney(transfer.getTransactionAmount(), senderAccount.getAccountId());
            transfer.setTransactionType("WITHDRAW");
            transfer.setReasonMessage("Money withdraw due to exchange");
            transfer.setTransactionStatus(TransactionStatus.COMPLETED.toString());
            transactionDao.create(transfer);
        }
        return transfer;
    }

    public Transaction exchangeOperation(Transaction transfer) {
        Account senderAccount = accountDao.getById(transfer.getSenderAccount().getAccountId());
        Account receiverAccount = accountDao.getById(transfer.getReceiverAccount().getAccountId());
        Currency currency = currencyDao.getConversionPair(senderAccount.getAccountCurrencyType(), receiverAccount.getAccountCurrencyType());
        String conversionPair = senderAccount.getAccountCurrencyType() + "/" + receiverAccount.getAccountCurrencyType();
        String bankConversionPair = currency.getFirsCurrency() + "/" + currency.getSecondCurrency();
        if (bankConversionPair.equals(conversionPair)) {
            double convertedAmount = transfer.getTransactionAmount() * currency.getConversionRate();
            transfer.setCurrencyType(conversionPair);
            transfer.setTransactionType("EXCHANGE");
            transfer.setReasonMessage("Buying foreign currency");
            transfer.setTransactionStatus(TransactionStatus.COMPLETED.toString());
            transfer.setTransactionAmount(convertedAmount);
            transactionDao.create(transfer);
        } else {
            transfer.setCurrencyType(conversionPair);
            transfer.setTransactionType("EXCHANGE");
            transfer.setReasonMessage("Rejected, the Bank can't convert to this currency");
            transfer.setTransactionStatus(TransactionStatus.REJECTED.toString());
            transactionDao.create(transfer);
        }
        return transfer;
    }

    public Transaction sendExchangedMoney(Transaction transfer) {
        Account receiverAccount = accountDao.getById(transfer.getReceiverAccount().getAccountId());
        accountDao.depositMoney(transfer.getTransactionAmount(), receiverAccount.getAccountId());
        transfer.setTransactionType("TRANSFER");
        transfer.setReasonMessage("Transaction was successful");
        transfer.setTransactionStatus(TransactionStatus.COMPLETED.toString());
        transfer.setCurrencyType(receiverAccount.getAccountCurrencyType());
        transactionDao.create(transfer);
        return transfer;
    }

    public String convertAmountToAnotherCurrency(Transaction transfer) {
        Transaction exchange = new Transaction();
        exchange = withdrawMoneyForExchange(transfer);
        exchange = exchangeOperation(exchange);
        exchange = sendExchangedMoney(exchange);
        return exchange.getReasonMessage();
    }

    public Transaction saveTransactionIntoDB(Transaction transfer) {
        Account senderAccount = accountDao.getById(transfer.getSenderAccount().getAccountId());
        //TODO: think about receiver account if belongs to another bank
        if (transfer.getTransactionAmount() > senderAccount.getAccountAmount()) {
            transfer.setReasonMessage("Warning insufficient Funds, transaction is declined");
            transfer.setTransactionStatus(TransactionStatus.REJECTED.toString());
            transactionDao.create(transfer);
        } else {
            transfer.setReasonMessage("Transaction was successful");
            transfer = transactionDao.create(transfer);
        }
        //return transaction with Id instead of message
        return transfer;
    }

    public Transaction withdrawAndDepositFunds(Transaction transfer) {
        Account senderAccount = accountDao.getById(transfer.getSenderAccount().getAccountId());
        Account receiverAccount = accountDao.getById(transfer.getReceiverAccount().getAccountId());
        if (Objects.nonNull(transfer.getSenderAccount()) && Objects.nonNull(transfer.getReceiverAccount())) {
            //transaction status flow, remake
            accountDao.withdrawMoney(transfer.getTransactionAmount(), senderAccount.getAccountId());
            accountDao.depositMoney(transfer.getTransactionAmount(), receiverAccount.getAccountId());
            transfer.setTransactionStatus(TransactionStatus.COMPLETED.toString());
        } else {
            if (Objects.nonNull(transfer.getSenderAccount()))
                accountDao.withdrawMoney(transfer.getTransactionAmount(), senderAccount.getAccountId());
            if (Objects.nonNull(transfer.getReceiverAccount()))
                accountDao.depositMoney(transfer.getTransactionAmount(), receiverAccount.getAccountId());
            transfer.setTransactionStatus(TransactionStatus.PENDING.toString());
        }
        return transfer;
    }

    public Transaction checkIfAccountIsBankRegistered(Transaction transfer) {
        TransactionAccount receiverTransactionAccount = transactionAccountDao.getTransactionAccountByCardNumber(transfer.getReceiverAccount().getCardNumber());
        TransactionAccount senderTransactionAccount = transactionAccountDao.getTransactionAccountByAccountId(transfer.getSenderAccount().getAccountId());
        if (Objects.isNull(accountDao.getById(transfer.getSenderAccount().getAccountId())) &&
                Objects.isNull(accountDao.getById(transfer.getReceiverAccount().getAccountId())) &&
                Objects.isNull(receiverTransactionAccount) && Objects.isNull(senderTransactionAccount)) {
            transfer.setReasonMessage("Transfer can't be done since both account doesn't exist");
            return transfer;
        }
        transfer.setReceiverAccount(receiverTransactionAccount);
        transfer.setSenderAccount(senderTransactionAccount);
        return transfer;
    }


    @Override
    public String registerTransaction(Transaction transfer) {
        //1:verify if the sender account belongs to our bank
        //2:verify if the receiver account belong to our bank
        //3:if one of the accounts belong to our bank add it in transaction object
        //4:save transaction into DB,
        //5:updates account sum according to transaction
        TransactionAccount receiverTransactionAccount = transactionAccountDao.getTransactionAccountByCardNumber(transfer.getReceiverAccount().getCardNumber());
        TransactionAccount senderTransactionAccount = transactionAccountDao.getTransactionAccountByAccountId(transfer.getSenderAccount().getAccountId());
        transfer.setReceiverAccount(receiverTransactionAccount);
        transfer.setSenderAccount(senderTransactionAccount);
        transfer.setTransactionType("TRANSFER");
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            String P2PAddress = "http://localhost:8081/transaction/send-object";
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Transaction> requestEntity = new HttpEntity<>(transfer, headers);
            ResponseEntity<Transaction> response = restTemplate.exchange(P2PAddress, HttpMethod.POST, requestEntity, Transaction.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println(transfer.getReasonMessage());
            }
        }catch (HttpClientErrorException | HttpServerErrorException ex){
            ex.printStackTrace();
        }
        if (Objects.equals(transfer.getReasonMessage(), "Transfer can't be done since both account doesn't exist")) {
            return transfer.getReasonMessage();
        }
        return transfer.getReasonMessage();
    }
}