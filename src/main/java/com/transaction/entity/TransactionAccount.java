package com.transaction.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//entity info about sending and receiving funds
public class TransactionAccount {
    private int transactionAccountId;
    private int accountId;
    @Min(value =16, message = "please enter the correct card number")
    @Max(value=16,message = "please enter the correct card number")
    @NotNull
    private long cardNumber;
    private String cardVendorType;
    private String IBAN;
    private String bankName;
    private String bankAddress;
    private String BIC;



    public TransactionAccount(int transactionAccountId, int accountId, long cardNumber, String cardVendorType, String IBAN, String bankName, String bankAddress, String BIC) {
        this.transactionAccountId = transactionAccountId;
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.cardVendorType = cardVendorType;
        this.IBAN = IBAN;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.BIC = BIC;
    }

    public TransactionAccount() {
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
