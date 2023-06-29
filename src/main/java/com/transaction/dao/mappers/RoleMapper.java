package com.transaction.dao.mappers;

import com.transaction.entity.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Role(
                rs.getInt("user_role_id"),
                rs.getString("user_role_name"),
                rs.getInt("user_id"));
    }
}
