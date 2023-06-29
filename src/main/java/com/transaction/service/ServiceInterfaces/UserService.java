package com.transaction.service.ServiceInterfaces;

import com.transaction.entity.Page;
import com.transaction.entity.User;

public interface UserService {
    Page<User> getAllUsers(int elementsPerPage, int pageIndex);

}
