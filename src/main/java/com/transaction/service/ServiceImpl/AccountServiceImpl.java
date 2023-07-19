package com.transaction.service.ServiceImpl;

import com.transaction.dao.implementation.AccountDaoImpl;
import com.transaction.entity.Account;
import com.transaction.entity.Page;
import com.transaction.service.ServiceInterfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDaoImpl accountDao;

    public void withdrawMoneyFromAccount(double amount, int accountId) {
        accountDao.withdrawMoney(amount, accountId);
    }

    public void depositMoneyToAccount(double amount, int accountId) {
        accountDao.depositMoney(amount, accountId);
    }

    //TODO: remake it after into a DTO, to create a user along with account
    @Override
    public Account createAccount(Account newAccount) {
        Account createdAccount = new Account();
        createdAccount.setUserId(newAccount.getUserId());
        createdAccount.setIBAN(newAccount.getIBAN());
        createdAccount.setAccountType(newAccount.getAccountType());
        createdAccount.setAccountStatus(newAccount.getAccountStatus());
        createdAccount.setExpiryDate(newAccount.getExpiryDate());
        accountDao.create(createdAccount);
        return createdAccount;
    }

    @Override
    public Page<Account> getPagedAccount(int elementsPerPage, int pageIndex) {
        return new Page<>(accountDao.getListOfRecords(elementsPerPage, pageIndex), accountDao.countAllRecords(), elementsPerPage, pageIndex);
    }

    public List<Account> getListOfAccountsById(int userId) {
        return accountDao.getUserAccount(userId);
    }
    public Account getAccountByID(int accountId){
        return accountDao.getById(accountId);
    }
}
