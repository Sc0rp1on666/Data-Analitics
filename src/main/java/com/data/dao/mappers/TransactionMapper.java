package com.data.dao.mappers;

import com.data.entity.Transaction;
import com.data.entity.TransactionAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Transaction(
                rs.getInt("transaction_id"),
                rs.getString("transaction_type"),
                rs.getString("transaction_status"),
                new TransactionAccount(),
                new TransactionAccount(),
                rs.getDate("transaction_date")
        );
    }
}
