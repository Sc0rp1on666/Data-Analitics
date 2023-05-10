package com.data.service.ServiceImpl;

import com.data.dao.implementation.UserDaoImpl;
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
    public List<User> getAllUsers() {
        System.out.println("Service");
        return userDao.getAllRecords();
    }
}
