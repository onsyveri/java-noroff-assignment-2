package com.example.assignment2;

import com.example.assignment2.dataaccess.ChinookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment2Application implements ApplicationRunner {

    @Autowired
    ChinookDAO chinookDAO;

    public static void main(String[] args) {
        SpringApplication.run(Assignment2Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        chinookDAO.test();
    }

}
