package com.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class Transaction {
    private long transactionId;
    private String transactionType;
    private String transactionStatus;

    private TransactionAccount senderAccount;

    private TransactionAccount receiverAccount;
    //currency type add
    private String currencyType;
    private double transactionAmount;
    private String reasonMessage;

    //TODO: add a reason message for transactions

    //TODO: add more date in dependency of a status, possible statuses:
    // Invalid or Incomplete, Canceled by customer, refused, order stored(on P2P transfer), authorized, refund ???
    //not enough funds error,saved success, pending
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date transactionDate;


    public Transaction() {
    }

    public Transaction(long transactionId, String transactionType, String transactionStatus,
                       TransactionAccount senderAccount, TransactionAccount receiverAccount,
                       String currencyType, double transactionAmount, String reasonMessage, Date transactionDate) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.currencyType = currencyType;
        this.transactionAmount = transactionAmount;
        this.reasonMessage = reasonMessage;
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

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getReasonMessage() {
        return reasonMessage;
    }

    public void setReasonMessage(String reasonMessage) {
        this.reasonMessage = reasonMessage;
    }
}
