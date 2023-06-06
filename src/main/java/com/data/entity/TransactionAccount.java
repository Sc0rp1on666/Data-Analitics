package com.data.entity;


public class TransactionAccount {
    private int transactionAccountId;
    //not needed
    //remade fullName to accountId
    private int accountId;
    private String IBAN;
    private String bankName;
    private String bankAddress;
    private String BIC;

    public TransactionAccount(int transactionAccountId, int accountId, String IBAN, String bankName, String bankAddress, String BIC) {
        this.transactionAccountId = transactionAccountId;
        this.accountId = accountId;
        this.IBAN = IBAN;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.BIC = BIC;
    }

    public TransactionAccount() {
    }

    public int getTransactionAccountId() {
        return transactionAccountId;
    }

    public void setTransactionAccountId(int transactionAccountId) {
        this.transactionAccountId = transactionAccountId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }
}
