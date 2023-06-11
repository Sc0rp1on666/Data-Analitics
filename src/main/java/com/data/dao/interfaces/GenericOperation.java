package com.data.dao.interfaces;

import java.util.List;

public interface GenericOperation<T> {

    List<T> getListOfRecords(int elementsPerPage, int pageIndex);
    T getById(int id);
    T create(T entity);
    void update(T entity, int id);
    int countAllRecords();
}
