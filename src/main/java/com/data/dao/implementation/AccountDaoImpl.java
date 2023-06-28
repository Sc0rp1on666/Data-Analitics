package com.data.dao.implementation;

import com.data.dao.interfaces.AccountDao;
import com.data.dao.mappers.AccountMapper;
import com.data.entity.Account;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class AccountDaoImpl extends GenericOperationImpl<Account> implements AccountDao {

    public AccountDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public Boolean checkIfAccountExist(int accountId){
        String query="SELECT user_id FROM account WHERE account_id=?";
        try {
            return getJdbcTemplate().queryForObject(query,boolean.class,accountId);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }


    public double retrieveAccountAmount (int accountId){
        String query =" SELECT account_amount FROM account WHERE account_id=?";
        try{
            return getJdbcTemplate().queryForObject(query, double.class, accountId);
        }catch (SQLException| NullPointerException ex){
            ex.printStackTrace();
        }return 0;
    }


    public double depositMoney(double operationAmount, int accountId){
        String query="UPDATE account SET account_amount= account_amount + ? WHERE account_id=?";
        try{
            getJdbcTemplate().update(query,operationAmount, accountId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public double withdrawMoney(double operationAmount, int accountId){
        //TODO:remake as should return remaining sum instead of void, for deposit should be the same
        String query="UPDATE account SET account_amount= account_amount - ? WHERE account_id=?";
        try{
            getJdbcTemplate().update(query,operationAmount, accountId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Account> getListOfRecords(int elementsPerPage, int pageIndex) {
        String query = "SELECT * FROM account LIMIT  ? OFFSET  ?";
        try {
            return getJdbcTemplate().query(query, new AccountMapper(), elementsPerPage, (pageIndex - 1) * elementsPerPage);
        } catch (SQLException | EmptyResultDataAccessException ex) {
            ex.printStackTrace();
        }return Collections.EMPTY_LIST;
    }

    public List<Account> getUserAccount(int userId){
        String query ="SELECT * FROM account WHERE userId=?";
        try{
            return getJdbcTemplate().query(query,new AccountMapper(), userId);
        }catch (SQLException | EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }return Collections.EMPTY_LIST;
    }

    @Override
    public Account getById(int accountId) {
        String query = "SELECT * FROM account WHERE account_id=?";
        try {
            return getJdbcTemplate().queryForObject(query, new AccountMapper(), accountId);
        } catch (SQLException | EmptyResultDataAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Account create(Account account) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO account VALUES(default , ? , ? , ? , ? , ? , ? , ? , CURRENT_TIMESTAMP )";
        try {
            getJdbcTemplate().update(con -> {
                PreparedStatement prepstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                prepstm.setInt(1, account.getUserId());
                prepstm.setString(2, account.getIBAN());
                prepstm.setString(3, account.getAccountType());
                prepstm.setString(4, account.getAccountStatus());
                prepstm.setString(5,account.getAccountCurrencyType());
                prepstm.setDouble(6,account.getAccountAmount());
                prepstm.setDate(7, account.getExpiryDate());
                return prepstm;
            }, keyHolder);
            return account;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return null;
    }

    @Override
    public void update(Account account, int id) {
        String query = "UPDATE account SET user_id=? IBAN=? account_type=? account_status=? " +
                " expiry_date=? WHERE account_id=?";
        try {
            getJdbcTemplate().update(query,
                    account.getUserId(),
                    account.getIBAN(),
                    account.getAccountType(),
                    account.getAccountStatus(),
                    account.getAccountCurrencyType(),
                    account.getAccountAmount(),
                    account.getExpiryDate(),
                    id
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int countAllRecords() {
        String query = "SELECT count(*) FROM account";
        try {
            return getJdbcTemplate().queryForObject(query, Integer.class);
        } catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
