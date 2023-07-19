package com.transaction.service.ServiceInterfaces;


import com.transaction.entity.Account;
import com.transaction.entity.Page;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account newAccount);

    public Page<Account> getPagedAccount(int pageIndex, int elementsPerPage);

    public Account getAccountByID(int accountId);

    public List<Account> getListOfAccountsById(int userId);

}
