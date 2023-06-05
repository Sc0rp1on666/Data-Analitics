package com.data.service.ServiceImpl;

import com.data.dao.implementation.UserDaoImpl;
import com.data.entity.Page;
import com.data.entity.User;
import com.data.service.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;

    @Override
    public Page<User> getAllUsers(int elementsPerPage, int pageIndex) {
        return new Page<>(userDao.getAllRecords(elementsPerPage, pageIndex), userDao.countAllRecords(), pageIndex,elementsPerPage);
    }
}
