package com.transaction.dao.mappers;

import com.transaction.entity.Transaction;
import com.transaction.entity.TransactionAccount;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
public class TransactionMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        TransactionAccount senderAccount = new TransactionAccount();
        senderAccount.setTransactionAccountId(rs.getInt("transaction_sender_account_id"));
        senderAccount.setAccountId(rs.getInt("sender_account_id"));
        senderAccount.setCardNumber(rs.getLong("sender_account_card_number"));
        senderAccount.setCardVendorType(rs.getString("sender_account_vendor_type"));
        senderAccount.setIBAN(rs.getString("sender_IBAN"));
        senderAccount.setBankName(rs.getString("sender_bank_name"));
        senderAccount.setBankAddress(rs.getString("sender_bank_address"));
        senderAccount.setBIC(rs.getString("sender_BIC"));
        TransactionAccount receiverAccount= new TransactionAccount();
        receiverAccount.setTransactionAccountId(rs.getInt("transaction_receiver_account_id"));
        receiverAccount.setAccountId(rs.getInt("receiver_account_id"));
        receiverAccount.setCardNumber(rs.getLong("receiver_account_card_number"));
        receiverAccount.setCardVendorType(rs.getString("receiver_account_vendor_type"));
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
                rs.getString("transaction_currency_type"),
                rs.getDouble("transaction_amount"),
                rs.getString("transaction_reason_message"),
                rs.getDate("transaction_date")
        );
    }
}
