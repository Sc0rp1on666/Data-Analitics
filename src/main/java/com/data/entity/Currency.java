package com.data.entity;


public class Currency {
    //missing S from Solid, maybe add an transaction_account_id which belongs to bank for transaction in different currency
    private int currencyId;
    private String currencyPair;
    private double conversionRate;

    public Currency(int currencyId, String currencyPair, double conversionRate) {
        this.currencyId = currencyId;
        this.currencyPair = currencyPair;
        this.conversionRate = conversionRate;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
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


