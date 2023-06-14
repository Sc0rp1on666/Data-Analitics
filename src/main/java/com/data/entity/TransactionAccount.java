package com.data.entity;

//entity info about sending and receiving funds
public class TransactionAccount {
    private int transactionAccountId;
    //not needed
    //remade fullName to accountId
    private int accountId;
    private long cardNumber;
    //remove account amount and card Currency type
    private String cardVendorType;
    private String cardCurrencyType;
    private double accountAmount;
    private String IBAN;
    private String bankName;
    private String bankAddress;
    private String BIC;

    public TransactionAccount(int transactionAccountId, int accountId, long cardNumber, String cardVendorType, String cardCurrencyType, double accountAmount, String IBAN, String bankName, String bankAddress, String BIC) {
        this.transactionAccountId = transactionAccountId;
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.cardVendorType = cardVendorType;
        this.cardCurrencyType = cardCurrencyType;
        this.accountAmount = accountAmount;
        this.IBAN = IBAN;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.BIC = BIC;
    }

    public TransactionAccount() {
    }

    public String getCardCurrencyType() {
        return cardCurrencyType;
    }

    public void setCardCurrencyType(String cardCurrencyType) {
        this.cardCurrencyType = cardCurrencyType;
    }

    public double getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(double accountAmount) {
        this.accountAmount = accountAmount;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardVendorType() {
        return cardVendorType;
    }

    public void setCardVendorType(String cardVendorType) {
        this.cardVendorType = cardVendorType;
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
