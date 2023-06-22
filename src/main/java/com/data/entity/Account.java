package com.data.entity;

import java.sql.Date;
import java.util.List;

//TODO: please review SOLID principle in special S, add userId in DB version control
public class Account {
   private int accountId;
   private int userId;
   private List<CustomConfiguration> accountConfiguration;
   private String IBAN;
   private String accountType;
   private String accountStatus;
   private String accountCurrencyType;
   private double accountAmount;
   private Date expiryDate;
   private Date createdDate;
   // the money should be deposit in account and currency



   public Account(int accountId, int userId, List<CustomConfiguration> accountConfiguration, String IBAN,
                  String accountType, String accountStatus, String accountCurrencyType , double accountAmount, Date expiryDate, Date createdDate) {
      this.accountId = accountId;
      this.userId = userId;
      this.accountConfiguration = accountConfiguration;
      this.IBAN = IBAN;
      this.accountType = accountType;
      this.accountStatus = accountStatus;
      this.accountCurrencyType = accountCurrencyType ;
      this.accountAmount = accountAmount;
      this.expiryDate = expiryDate;
      this.createdDate = createdDate;
   }

   public Account() {
   }

   public int getAccountId() {
      return accountId;
   }

   public void setAccountId(int accountId) {
      this.accountId = accountId;
   }

   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public String getIBAN() {
      return IBAN;
   }

   public void setIBAN(String IBAN) {
      this.IBAN = IBAN;
   }

   public String getAccountType() {
      return accountType;
   }

   public void setAccountType(String accountType) {
      this.accountType = accountType;
   }

   public String getAccountStatus() {
      return accountStatus;
   }

   public void setAccountStatus(String accountStatus) {
      this.accountStatus = accountStatus;
   }

   public Date getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(Date expiryDate) {
      this.expiryDate = expiryDate;
   }

   public String getAccountCurrencyType() {
      return accountCurrencyType ;
   }

   public void setAccountCurrencyType (String accountCurrencyType ) {
      this.accountCurrencyType  = accountCurrencyType;
   }

   public double getAccountAmount() {
      return accountAmount;
   }

   public void setAccountAmount(double accountAmount) {
      this.accountAmount = accountAmount;
   }

   public Date getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
   }

   public List<CustomConfiguration> getAccountConfiguration() {
      return accountConfiguration;
   }

   public void setAccountConfiguration(List<CustomConfiguration> accountConfiguration) {
      this.accountConfiguration = accountConfiguration;
   }
}
