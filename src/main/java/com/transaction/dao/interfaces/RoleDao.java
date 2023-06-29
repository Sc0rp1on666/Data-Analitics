package com.transaction.dao.interfaces;

import com.transaction.entity.Role;

import java.util.List;

public interface RoleDao extends GenericOperation<Role>{
    List<Role> getRoles(int userId);
}
