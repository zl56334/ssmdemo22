package com.example.ssmdemo22;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.ssmdemo22.demos.mapper")
public class Ssmdemo22Application {

    public static void main(String[] args) {
        SpringApplication.run(Ssmdemo22Application.class, args);
    }

}
