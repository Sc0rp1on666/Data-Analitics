package com.data.entity;


public class Currency {
    //missing S from Solid
    private int currencyId;
    private String currency;
    private double amount;

    public Currency(int currencyId, String currency, double amount) {
        this.currencyId = currencyId;
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

}


