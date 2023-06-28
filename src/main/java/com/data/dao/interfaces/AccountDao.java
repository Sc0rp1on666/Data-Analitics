package com.data.dao.interfaces;

import com.data.entity.Account;

public interface AccountDao extends GenericOperation<Account>{

     double depositMoney(double operationAmount, int accountId);

     double withdrawMoney(double operationAmount, int accountId);

     double retrieveAccountAmount (int accountId);
}
