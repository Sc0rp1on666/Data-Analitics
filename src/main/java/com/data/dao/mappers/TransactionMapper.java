package com.data.dao.mappers;

import com.data.entity.Transaction;
import com.data.entity.TransactionAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class TransactionMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        TransactionAccount senderAccount = new TransactionAccount();
        senderAccount.setTransactionAccountId(rs.getInt("transaction_sender_account_id"));
        senderAccount.setAccountId(rs.getInt("sender_account_id"));
        senderAccount.setIBAN(rs.getString("sender_IBAN"));
        senderAccount.setBankName(rs.getString("sender_bank_name"));
        senderAccount.setBankAddress(rs.getString("sender_bank_address"));
        senderAccount.setBIC(rs.getString("sender_BIC"));
        TransactionAccount receiverAccount= new TransactionAccount();
        receiverAccount.setTransactionAccountId(rs.getInt("transaction_receiver_account_id"));
        receiverAccount.setAccountId(rs.getInt("receiver_account_id"));
        receiverAccount.setIBAN(rs.getString("receiver_IBAN"));
        receiverAccount.setBankName(rs.getString("receiver_bank_name"));
        receiverAccount.setBankAddress(rs.getString("receiver_bank_address"));
        receiverAccount.setBIC(rs.getString("receiver_BIC"));
        return new Transaction(
                rs.getInt("transaction_id"),
                rs.getString("transaction_type"),
                rs.getString("transaction_status"),
                senderAccount,
                receiverAccount,
                rs.getDouble("transaction_amount"),
                rs.getDate("transaction_date")
        );
    }
}
