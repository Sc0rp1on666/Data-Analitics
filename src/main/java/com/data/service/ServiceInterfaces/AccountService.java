package com.data.service.ServiceInterfaces;


import com.data.entity.Account;
import com.data.entity.Page;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account newAccount);

    public Page<Account> getPagedAccount(int pageIndex, int elementsPerPage);

    public List<Account> getAccountById(int userId);

}
