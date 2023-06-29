package com.transaction.service.ServiceInterfaces;


import com.transaction.entity.Account;
import com.transaction.entity.Page;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account newAccount);

    public Page<Account> getPagedAccount(int pageIndex, int elementsPerPage);

    public List<Account> getAccountById(int userId);

}
