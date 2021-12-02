package com.codecool.tradingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication
public class TradingprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradingprojectApplication.class, args);
    }
}
