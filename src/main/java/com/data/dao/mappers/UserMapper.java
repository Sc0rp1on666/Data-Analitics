package com.data.dao.mappers;

import com.data.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
            rs.getInt("user_id"),
            new ArrayList<>(),
            rs.getString("idnp"),
            rs.getString("seria"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("address"),
            rs.getString("password"),
            rs.getDate("date_of_birth"),
            rs.getDate("created_date")
        );
    }
}
