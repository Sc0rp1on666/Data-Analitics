package com.transaction.dao.implementation;

import com.transaction.dao.interfaces.GenericOperation;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

public abstract class GenericOperationImpl<T> implements GenericOperation<T> {
    private final JdbcTemplate jdbcTemplate;

    public GenericOperationImpl(DataSource dataSource) {
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }

    protected JdbcTemplate getJdbcTemplate()throws SQLException{
        return jdbcTemplate;
    }
}
