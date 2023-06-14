package com.data.dao.implementation;

import com.data.dao.interfaces.TransactionDao;
import com.data.dao.mappers.TransactionMapper;
import com.data.entity.Transaction;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
@Repository
public class TransactionDaoImpl extends GenericOperationImpl<Transaction> implements TransactionDao {
    public TransactionDaoImpl(DataSource dataSource) {
        super(dataSource);
    }
    //most probably will be need to remake this
    @Override
    public List<Transaction> getListOfRecords(int elementsPerPage, int pageIndex) {
       String query = "SELECT tr.transaction_id , tr.transaction_type ,tr.transaction_status ,tr.transaction_sender_account_id ,tr.transaction_receiver_account_id ,tr.transaction_amount ,tr.transaction_date, \n"+
        "ta.transaction_account_id as sender_account_id, ta.account_id as sender_account_id , ta.IBAN as sender_IBAN, ta.bank_name as sender_bank_name , ta.bank_address as sender_bank_address, ta.BIC as sender_BIC, \n"+
        "ta2.transaction_account_id as receiver_account_id, ta.account_id as receiver_account_id , ta.IBAN as receiver_IBAN, ta.bank_name as receiver_bank_name , ta.bank_address as receiver_bank_address, ta.BIC as receiver_BIC \n"+
               "FROM transaction AS tr \n" +
               "INNER JOIN transaction_account ta ON tr.transaction_sender_account_id=ta.transaction_account_id \n" +
               "INNER JOIN transaction_account ta2 ON tr.transaction_receiver_account_id=ta2.transaction_account_id \n" +
               "LIMIT ? OFFSET ?";
       try {
           return getJdbcTemplate().query(query,new TransactionMapper(),elementsPerPage,(pageIndex - 1) * elementsPerPage);
       }catch (SQLException ex){
           ex.printStackTrace();
       }return Collections.EMPTY_LIST;
    }

    @Override
    public Transaction getById(int id) {
        String query = "SELECT tr.transaction_id , tr.transaction_type ,tr.transaction_status ,tr.transaction_sender_account_id ,tr.transaction_receiver_account_id ,tr.transaction_amount ,tr.transaction_date, \n"+
                "ta.transaction_account_id as sender_account_id, ta.account_id as sender_account_id , ta.IBAN as sender_IBAN, ta.bank_name as sender_bank_name , ta.bank_address as sender_bank_address, ta.BIC as sender_BIC, \n"+
                "ta2.transaction_account_id as receiver_account_id, ta.account_id as receiver_account_id , ta.IBAN as receiver_IBAN, ta.bank_name as receiver_bank_name , ta.bank_address as receiver_bank_address, ta.BIC as receiver_BIC \n"+
                "FROM transaction AS tr \n" +
                "INNER JOIN transaction_account ta ON tr.transaction_sender_account_id=ta.transaction_account_id \n" +
                "INNER JOIN transaction_account ta2 ON tr.transaction_receiver_account_id=ta2.transaction_account_id \n"+
                "WHERE tr.transaction_id=?";
        try {
           return getJdbcTemplate().queryForObject(query,new TransactionMapper(), id);
        }catch (SQLException ex){
            ex.printStackTrace();
        }return null;
    }

    @Override
    public Transaction create(Transaction transaction) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO transaction VALUES(default, ? , ?, ? , ? , ?,CURRENT_TIMESTAMP)";
        try{
            getJdbcTemplate().update(con -> {
                PreparedStatement prepstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                prepstm.setString(1,transaction.getTransactionType());
                prepstm.setString(2,transaction.getTransactionStatus());
                prepstm.setInt(3,transaction.getSenderAccount().getTransactionAccountId());
                prepstm.setInt(4,transaction.getReceiverAccount().getTransactionAccountId());
                prepstm.setDouble(5,transaction.getTransactionAmount());
                return prepstm;
            },keyHolder);
            return transaction;
        }catch (SQLException ex){
            ex.printStackTrace();
        }return null;
    }

    @Override
    public void update(Transaction transaction, int id) {
    String query="UPDATE transaction SET transaction_type=? transaction_status";
        try {
             getJdbcTemplate().update(query,
                     transaction.getTransactionType(),
                     transaction.getTransactionStatus(),
                     transaction.getReceiverAccount().getTransactionAccountId(),
                     transaction.getReceiverAccount().getTransactionAccountId(),
                     transaction.getTransactionAmount(),
                     id);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int countAllRecords() {
        String query = "SELECT count(*) FROM transaction";
        try{
            getJdbcTemplate().queryForObject(query, Integer.class);
        }catch (SQLException ex){
            ex.printStackTrace();
        }return 0;
    }

    @Override
    public List<Transaction> getTransactionHistoryByTransactionAccount(int transactionAccountId) {
        //for further dev will be needed to remake this
        String query="SELECT * FROM transaction where transaction_sender_account_id=? or transaction_receiver_account_id=?";
        try {
           return getJdbcTemplate().query(query, new TransactionMapper(), transactionAccountId, transactionAccountId);
        }catch (SQLException ex){
            ex.printStackTrace();
        }return Collections.EMPTY_LIST;
    }
}
