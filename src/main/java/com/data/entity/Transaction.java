package com.data.entity;

import java.sql.Date;

public class Transaction {
    private long transactionId;
    private String transactionType;
    private String transactionStatus;

    private TransactionAccount senderAccount;

    private TransactionAccount receiverAccount;
    //currency type add
    private double transactionAmount;

    //from separate entity
//    private String CurrencyCode;
//    private double transactionAmount;
    //separate entity transaction account, bank related
//    private String fullName;
//    private long IBAN;
    //TODO: add more date in dependency of a status
    private Date transactionDate;
    //audit
//    private Date lastUpdate;
//    private String modifiedBy;


    public Transaction(long transactionId, String transactionType, String transactionStatus, TransactionAccount senderAccount, TransactionAccount receiverAccount, double transactionAmount, Date transactionDate) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public TransactionAccount getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(TransactionAccount senderAccount) {
        this.senderAccount = senderAccount;
    }

    public TransactionAccount getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(TransactionAccount receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
