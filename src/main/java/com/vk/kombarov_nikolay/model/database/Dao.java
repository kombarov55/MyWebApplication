package com.vk.kombarov_nikolay.model.database;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by nikolaykombarov on 26.01.17.
 */
public interface Dao<T> {

    void add(T obj) throws SQLException;

    void remove(String primaryKey) throws SQLException;

    void update(String primaryKey, Map<String, String> params) throws SQLException;

    T get(String primaryKey) throws SQLException;

    List<T> lookup(Map<String, String> params) throws SQLException;

}