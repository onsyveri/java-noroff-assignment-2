package com.example.assignment2.runners;

import com.example.assignment2.dataaccess.ChinookDAO;
import com.example.assignment2.models.Customer;
import com.example.assignment2.repositories.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    @Autowired
    public AppRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // System.out.println(customerRepository.findAll());
        /*Customer customer = new Customer(
                60,
                "Ole",
                "Syverinsen",
                "Norway",
                "1415",
                "111-44-222",
                "o@s.com"
        );*/
        System.out.println(customerRepository.limitAndOffset(4,5));
        System.out.println(customerRepository.findPopularGenreByName(12));
    }

}
