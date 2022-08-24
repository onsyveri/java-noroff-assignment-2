package com.example.assignment2.runners;

import com.example.assignment2.dataaccess.ChinookDAO;
import com.example.assignment2.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    final CustomerRepository customerRepository;

    public AppRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(customerRepository.findAll());
    }
}
