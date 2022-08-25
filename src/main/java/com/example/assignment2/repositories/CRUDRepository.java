package com.example.assignment2.repositories;

import java.util.List;

public interface CRUDRepository<T, U> {
    List<T> findAll();
    List<T> findById(int id);
    List<T> limitAndOffset(int limit, int offset);
    int insert(T object);
    int update(T object);
    int delete(T object);
    int deleteById(U id);

    int updateCustomer(int id, String first_name);
}
