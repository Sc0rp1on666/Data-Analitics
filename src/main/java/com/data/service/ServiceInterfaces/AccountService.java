package com.data.service.ServiceInterfaces;


import com.data.entity.Account;
import com.data.entity.Page;

public interface AccountService {
    public Account createAccount(Account newAccount);

    public Page<Account> getPagedAccount(int pageIndex, int elementsPerPage);

    public Account getAccountById(int accountId);

}
