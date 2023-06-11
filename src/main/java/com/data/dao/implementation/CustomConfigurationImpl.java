package com.data.dao.implementation;

import com.data.dao.interfaces.CustomConfigurationDao;
import com.data.entity.CustomConfiguration;

import javax.sql.DataSource;
import java.util.List;

public class CustomConfigurationImpl extends GenericOperationImpl<CustomConfiguration> implements CustomConfigurationDao {
    public CustomConfigurationImpl(DataSource dataSource) {
        super(dataSource);
    }


    @Override
    public List<CustomConfiguration> getListOfRecords(int elementsPerPage, int pageIndex) {
        return null;
    }

    @Override
    public CustomConfiguration getById(int id) {
        return null;
    }

    @Override
    public CustomConfiguration create(CustomConfiguration entity) {
    return null;
    }

    @Override
    public void update(CustomConfiguration entity, int id) {

    }

    @Override
    public int countAllRecords() {
        return 0;
    }
}
