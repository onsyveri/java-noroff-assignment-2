package com.example.assignment2.runners;

import com.example.assignment2.dataaccess.ChinookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    final ChinookDAO chinookDAO;

    public AppRunner(ChinookDAO chinookDAO) {
        this.chinookDAO = chinookDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        chinookDAO.test();
    }
}
