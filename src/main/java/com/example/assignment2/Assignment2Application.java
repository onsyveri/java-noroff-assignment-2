package com.example.assignment2;

import com.example.assignment2.dataaccess.ChinookDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment2Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment2Application.class, args);
        ChinookDAO chinookDAO = new ChinookDAO();
    }

}
