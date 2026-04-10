package com.tg.nutricode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NutricodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(NutricodeApplication.class, args);
    }
}