package com.example.assignment2.repositories;

import java.util.List;

public interface CRUDRepository<T, U> {
    List<T> findAll();
    List<T> findById(int id);
    int insert(T object);
    int update(T object);
    int delete(T object);
    int deleteById(U id);
}
