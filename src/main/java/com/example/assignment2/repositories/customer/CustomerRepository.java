package com.example.assignment2.repositories.customer;

import com.example.assignment2.models.Customer;
import com.example.assignment2.models.CustomerCountry;
import com.example.assignment2.repositories.CRUDRepository;

import java.util.List;

public interface CustomerRepository extends CRUDRepository<Customer, Integer> {

    List<CustomerCountry> findCountry();
}
