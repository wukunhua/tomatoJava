package com.example.toamto;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.toamto.mapper")
public class ToamtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToamtoApplication.class, args);
    }

}
