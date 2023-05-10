package com.data.dao.implementation;

import com.data.dao.interfaces.GenericOperation;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

public abstract class GenericOperationImpl<T> implements GenericOperation<T> {
    private  JdbcTemplate jdbcTemplate;
    public void getDataSource(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    protected JdbcTemplate getJdbcTemplate()throws SQLException{
        return jdbcTemplate;
    }
}
