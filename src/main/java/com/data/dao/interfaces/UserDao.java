package com.data.dao.interfaces;

import com.data.entity.User;

public interface UserDao extends GenericOperation<User>{
    public User getUserByEmail(String email);
}
