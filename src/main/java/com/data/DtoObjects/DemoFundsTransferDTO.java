package com.data.DtoObjects;

import java.sql.Date;

public class DemoFundsTransferDTO {

    private String transactionType;
    private int senderAccount;
    private int receiverAccount;
    private double transactionAmount;

    public DemoFundsTransferDTO(String transactionType, int senderAccount, int receiverAccount, double transactionAmount) {
        this.transactionType = transactionType;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }


    public int getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(int senderAccount) {
        this.senderAccount = senderAccount;
    }

    public int getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(int receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

}
