package com.data.dao.mappers;

import com.data.entity.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyMapper implements RowMapper<Currency> {
    @Override
    public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Currency(
                rs.getInt("currency_id"),
                rs.getString("first_currency"),
                rs.getString("second_currency"),
                rs.getDouble("exchange_rate")
        );
    }
}
