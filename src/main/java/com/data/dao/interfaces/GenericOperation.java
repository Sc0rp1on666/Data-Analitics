package com.data.dao.interfaces;

import java.util.List;

public interface GenericOperation<T> {

    List<T> getAllRecords();
    T getById(int id);
    void create(T entity);
    void update(T entity, int id);
    void delete(int id);
}
