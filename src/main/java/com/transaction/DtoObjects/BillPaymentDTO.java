package com.transaction.DtoObjects;

public class BillPaymentDTO {
    private String IBAN;
    private String bankName;
    private String bankAddress;
    private String BIC;
    private double paymentAmount;
    private String paymentReason;

    public BillPaymentDTO(String IBAN, String bankName, String bankAddress, String BIC, double paymentAmount, String paymentReason) {
        this.IBAN = IBAN;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.BIC = BIC;
        this.paymentAmount = paymentAmount;
        this.paymentReason = paymentReason;
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

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentReason() {
        return paymentReason;
    }

    public void setPaymentReason(String paymentReason) {
        this.paymentReason = paymentReason;
    }
}
