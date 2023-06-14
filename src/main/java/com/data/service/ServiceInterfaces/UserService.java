package com.data.service.ServiceInterfaces;

import com.data.entity.Page;
import com.data.entity.User;

import java.util.List;

public interface UserService {
    Page<User> getAllUsers(int elementsPerPage, int pageIndex);

}
