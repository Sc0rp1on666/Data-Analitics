package com.data.dao.mappers;

import com.data.entity.CustomConfiguration;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomConfigurationMapper implements RowMapper<CustomConfiguration> {
    @Override
    public CustomConfiguration mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomConfiguration(
                rs.getInt("custom_configuration_id"),
                rs.getString("configuration_name"),
                rs.getInt("configuration_value")
        );
    }
}
