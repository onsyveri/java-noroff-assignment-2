package com.example.assignment2.repositories.customer;

import com.example.assignment2.models.Customer;
import com.example.assignment2.models.CustomerSpender;
import com.example.assignment2.repositories.CRUDRepository;

import java.util.List;

public interface CustomerRepository extends CRUDRepository<Customer, Integer> {
    // Find by name
    List<Customer> findByName(String name);

    //Finds customer who spends the most
    List<CustomerSpender> findHighestSpender();
}
