package com.data.dao.interfaces;

import com.data.entity.Role;

import java.util.List;

public interface RoleDao extends GenericOperation<Role>{
    List<Role> getRoles(int userId);
}
