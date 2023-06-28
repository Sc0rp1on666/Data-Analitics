package com.data.dao.implementation;

import com.data.dao.interfaces.CurrencyDao;
import com.data.dao.mappers.CurrencyMapper;
import com.data.entity.Currency;
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
public class CurrencyDaoImpl extends GenericOperationImpl<Currency> implements CurrencyDao {
    public CurrencyDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public Currency getConversionPair(String firstCurrency, String secondCurrency){
        String query="SELECT * FROM currency WHERE first_currency=? and second_currency=?";
        try{
            return getJdbcTemplate().queryForObject(query, new CurrencyMapper(), firstCurrency,secondCurrency);
        }catch (SQLException ex){
            ex.printStackTrace();
        }return null;
    }

    @Override
    public List<Currency> getListOfRecords(int elementsPerPage, int pageIndex) {
        String query = "SELECT * FROM currency LIMIT = ? OFFSET = ?";
        try {
            return getJdbcTemplate().query(query, new CurrencyMapper(), elementsPerPage, (pageIndex - 1) * elementsPerPage);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return Collections.EMPTY_LIST;
    }

    @Override
    public Currency getById(int currencyId) {
        String query = "SELECT * FROM currency WHERE currency_id=?";
        try {
            return getJdbcTemplate().queryForObject(query, new CurrencyMapper(), currencyId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Currency create(Currency currency) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "INSERT INTO currency VALUES(default , ? , ? , ? )";
        try {
            getJdbcTemplate().update(con -> {
                PreparedStatement prepstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                prepstm.setString(1, currency.getFirsCurrency());
                prepstm.setString(2, currency.getSecondCurrency());
                prepstm.setDouble(3, currency.getConversionRate());
                return prepstm;
            }, keyHolder);
            return currency;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }return null;
    }

    @Override
    public void update(Currency currency, int currencyId) {
        String query = "UPDATE currency SET first_currency=? second_currency conversion_rate=? " +
                "  WHERE currency_id=?";
        try {
            getJdbcTemplate().update(query,
                    currency.getFirsCurrency(),
                    currency.getSecondCurrency(),
                    currency.getConversionRate(),
                    currencyId
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int countAllRecords() {
        String query = "SELECT count(*) FROM currency";
        try {
            return getJdbcTemplate().queryForObject(query, Integer.class);
        } catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
