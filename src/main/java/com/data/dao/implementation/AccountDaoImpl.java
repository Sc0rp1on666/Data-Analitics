package com.data.dao.implementation;

import com.data.dao.interfaces.AccountDao;
import com.data.dao.mappers.AccountMapper;
import com.data.entity.Account;
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

    @Override
    public List<Account> getListOfRecords(int elementsPerPage, int pageIndex) {
        String query = "SELECT * FROM account LIMIT = ? OFFSET = ?";
        try {
            return getJdbcTemplate().query(query, new AccountMapper(), elementsPerPage, (pageIndex - 1) * elementsPerPage);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return Collections.EMPTY_LIST;
    }

    @Override
    public Account getById(int id) {
        String query = "SELECT * FROM account WHERE account_id=?";
        try {
            return getJdbcTemplate().queryForObject(query, new AccountMapper());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Account create(Account account) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO account VALUES(default , ? , ? , ? , ? , ? , ? , CURRENT_TIMESTAMP )";
        try {
            getJdbcTemplate().update(con -> {
                PreparedStatement prepstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                prepstm.setInt(1, account.getUserId());
                prepstm.setString(2, account.getIBAN());
                prepstm.setString(3, account.getAccountType());
                prepstm.setString(4, account.getAccountStatus());
                prepstm.setDouble(5, account.getAccountAmount());
                prepstm.setDate(6, account.getExpiryDate());
                return prepstm;
            }, keyHolder);
            return account;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return null;
    }

    @Override
    public void update(Account account, int id) {
        String query = "UPDATE account SET user_id=? IBAN=? account_type=? account_status=? account_amount=?" +
                " expiry_date=? WHERE account_id=?";
        try {
            getJdbcTemplate().update(query,
                    account.getUserId(),
                    account.getIBAN(),
                    account.getAccountType(),
                    account.getAccountStatus(),
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
