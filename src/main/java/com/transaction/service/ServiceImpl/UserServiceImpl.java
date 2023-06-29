package com.transaction.service.ServiceImpl;

import com.transaction.dao.implementation.UserDaoImpl;
import com.transaction.entity.Page;
import com.transaction.entity.User;
import com.transaction.service.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;

    @Override
    public Page<User> getAllUsers(int elementsPerPage, int pageIndex) {
        return new Page<>(userDao.getListOfRecords(elementsPerPage, pageIndex), userDao.countAllRecords(), pageIndex,elementsPerPage);
    }
}
