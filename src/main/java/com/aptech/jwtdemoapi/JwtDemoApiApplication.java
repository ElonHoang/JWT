package com.aptech.jwtdemoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.aptech.jwtdemoapi")
public class JwtDemoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApiApplication.class, args);
    }

}
