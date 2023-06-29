package com.transaction.entity;


public class Currency {
    //missing S from Solid, maybe add an transaction_account_id which belongs to bank for transaction in different currency
    private int currencyId;
    private String firsCurrency;

    private String secondCurrency;
    private double conversionRate;

    public Currency(int currencyId, String firsCurrency, String secondCurrency, double conversionRate) {
        this.currencyId = currencyId;
        this.firsCurrency = firsCurrency;
        this.secondCurrency = secondCurrency;
        this.conversionRate = conversionRate;
    }

    public String getFirsCurrency() {
        return firsCurrency;
    }

    public void setFirsCurrency(String firsCurrency) {
        this.firsCurrency = firsCurrency;
    }

    public String getSecondCurrency() {
        return secondCurrency;
    }

    public void setSecondCurrency(String secondCurrency) {
        this.secondCurrency = secondCurrency;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

}


