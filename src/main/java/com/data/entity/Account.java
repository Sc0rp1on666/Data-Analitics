package com.data.entity;

import java.util.Currency;
import java.sql.Date;
import java.util.List;

//TODO: please review SOLID principle in special S, add userId in DB version control
public class Account {
    //should be unique based on this ID will be made transaction, read documentation IBAN
   private int accountId;
   private int userId;
   private List<CustomConfiguration> accountConfiguration;
   private String IBAN;
   private String accountType;
   private String accountStatus;
   //TODO: account amount not needed if there is a list of currency
   private double accountAmount;
   private Date expiryDate;
   private Date createdDate;
   //this is user fields, user profile
//   private long IDNP;
//   private String accountHolderFirstName;
//   private String accountHolderLastName;
//   private String accountSecretWord;
   //

//account currency should be separate entity, review about conversion, should be a list of currency
   private List<Currency> currency;


//account configuration, amount limit per transaction, optional, add link to custom config
//   private int transactionLimit;

   //audit entity for reviewing actions
//   private Date lastModifiedDate;
//   private String modifiedBy;


   public Account(int accountId, int userId, List<CustomConfiguration> accountConfiguration, String IBAN,
                  String accountType, String accountStatus, double accountAmount, Date expiryDate, Date createdDate,
                  List<Currency> currency) {
      this.accountId = accountId;
      this.userId = userId;
      this.accountConfiguration = accountConfiguration;
      this.IBAN = IBAN;
      this.accountType = accountType;
      this.accountStatus = accountStatus;
      this.accountAmount = accountAmount;
      this.expiryDate = expiryDate;
      this.createdDate = createdDate;
      this.currency = currency;
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

   public double getAccountAmount() {
      return accountAmount;
   }

   public void setAccountAmount(double accountAmount) {
      this.accountAmount = accountAmount;
   }

   public Date getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(Date expiryDate) {
      this.expiryDate = expiryDate;
   }

   public Date getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
   }

   public List<Currency> getCurrency() {
      return currency;
   }

   public void setCurrency(List<Currency> currency) {
      this.currency = currency;
   }

   public List<CustomConfiguration> getAccountConfiguration() {
      return accountConfiguration;
   }

   public void setAccountConfiguration(List<CustomConfiguration> accountConfiguration) {
      this.accountConfiguration = accountConfiguration;
   }
}
