package com.example.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaInitializer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("项目已经启动>>>>>>>>>>>>");
    }
}
