package com.data.dao.implementation;

import com.data.dao.interfaces.TransactionDao;
import com.data.dao.mappers.AccountMapper;
import com.data.dao.mappers.TransactionMapper;
import com.data.entity.Transaction;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class TransactionDaoImpl extends GenericOperationImpl<Transaction> implements TransactionDao {
    public TransactionDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Transaction> getAllRecords(int elementsPerPage, int pageIndex) {
       String query = "SELECT * FROM transaction LIMIT=? OFFSET=?";
       try {
           return getJdbcTemplate().query(query,new TransactionMapper(),elementsPerPage,pageIndex);
       }catch (SQLException ex){
           ex.printStackTrace();
       }return Collections.EMPTY_LIST;
    }

    @Override
    public Transaction getById(int id) {
        String query = "SELECT * FROM transaction WHERE transaction_id=?";
        try {
            getJdbcTemplate().queryForObject(query,new AccountMapper(), id)
        }catch (SQLException ex){
            ex.printStackTrace();
        }return null;
    }

    @Override
    public void create(Transaction transaction) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO transaction VALUES(default, ? , ? , ?)";
        try{
            getJdbcTemplate().update(con -> {
                PreparedStatement prepstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                prepstm.setString();
            })
        }
    }

    @Override
    public void update(Transaction transaction, int id) {

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
}
