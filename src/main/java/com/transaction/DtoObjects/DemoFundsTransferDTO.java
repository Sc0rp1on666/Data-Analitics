package com.transaction.DtoObjects;

public class DemoFundsTransferDTO {

    private String transactionType;
    private int senderAccount;
    private double transactionAmount;
    private long receiverCardNumber;

    public DemoFundsTransferDTO(String transactionType, int senderAccount, double transactionAmount, long receiverCardNumber) {
        this.transactionType = transactionType;
        this.senderAccount = senderAccount;
        this.transactionAmount = transactionAmount;
        this.receiverCardNumber = receiverCardNumber;
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

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public long getReceiverCardNumber() {
        return receiverCardNumber;
    }

    public void setReceiverCardNumber(long receiverCardNumber) {
        this.receiverCardNumber = receiverCardNumber;
    }
}
