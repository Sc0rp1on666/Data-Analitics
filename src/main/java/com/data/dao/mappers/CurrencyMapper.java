package com.data.dao.mappers;

import com.data.entity.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyMapper implements RowMapper<Currency> {
    @Override
    public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Currency(
                rs.getInt("currencyId"),
                rs.getString("currency_pair"),
                rs.getDouble("conversion_rate")
        );
    }
}
