package com.transaction.dao.mappers;

import com.transaction.entity.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Account(
                rs.getInt("account_id"),
                rs.getInt("user_id"),
                new ArrayList<>(),
                rs.getString("IBAN"),
                rs.getString("account_type"),
                rs.getString("account_status"),
                rs.getString("account_currency_type"),
                rs.getDouble("account_amount"),
                rs.getDate("expiry_date"),
                rs.getDate("created_date")
        );
    }
}
