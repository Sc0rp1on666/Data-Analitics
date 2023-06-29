package com.transaction.dao.interfaces;

import com.transaction.entity.User;

public interface UserDao extends GenericOperation<User>{
    public User getUserByEmail(String email);
}
