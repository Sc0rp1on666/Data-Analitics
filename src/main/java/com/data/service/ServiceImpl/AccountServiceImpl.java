package com.data.service.ServiceImpl;

import com.data.dao.implementation.AccountDaoImpl;
import com.data.entity.Account;
import com.data.entity.Page;
import com.data.service.ServiceInterfaces.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountDaoImpl accountDao;

    //TODO: remake it after into a DTO, to create a user along with account
    @Override
    public Account createAccount(Account newAccount) {
        Account createdAccount =  new Account();
        createdAccount.setUserId(newAccount.getUserId());
        createdAccount.setIBAN(newAccount.getIBAN());
        createdAccount.setAccountType(newAccount.getAccountType());
        createdAccount.setAccountStatus(newAccount.getAccountStatus());
        createdAccount.setAccountAmount(newAccount.getAccountAmount());
        createdAccount.setExpiryDate(newAccount.getExpiryDate());
        accountDao.create(createdAccount);
        return createdAccount;
    }

    @Override
    public Page<Account> getPagedAccount(int pageIndex, int elementsPerPage) {
       return new Page<> (accountDao.getAllRecords(pageIndex,elementsPerPage),accountDao.countAllRecords(),pageIndex,elementsPerPage);
    }

    @Override
    public Account getAccountById(int id) {
        return  accountDao.getById(id);
    }
}
