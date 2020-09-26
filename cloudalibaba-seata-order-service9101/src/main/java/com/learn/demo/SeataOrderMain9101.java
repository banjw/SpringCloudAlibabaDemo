package com.learn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SeataOrderMain9101 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain9101.class, args);
    }

}
