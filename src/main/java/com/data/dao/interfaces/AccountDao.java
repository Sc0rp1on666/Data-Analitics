package com.data.dao.interfaces;

import com.data.entity.Account;

public interface AccountDao extends GenericOperation<Account>{

     void depositMoney(double operationAmount, int accountId);

     void withdrawMoney(double operationAmount, int accountId);

     double retrieveAccountAmount (int accountId);
}
