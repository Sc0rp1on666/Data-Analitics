package com.transaction.dao.mappers;

import com.transaction.entity.TransactionAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionAccountMapper implements RowMapper<TransactionAccount> {
    @Override
    public TransactionAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TransactionAccount(
                rs.getInt("transaction_account_id"),
                rs.getInt("account_id"),
                rs.getLong("card_number"),
                rs.getString("card_vendor_type"),
                rs.getString("IBAN"),
                rs.getString("bank_name"),
                rs.getString("bank_address"),
                rs.getString("BIC")
        );
    }
}
