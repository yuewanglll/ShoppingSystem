package com.hmall.tarde;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hmall.tarde.mapper")
@SpringBootApplication
public class TardeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TardeApplication.class, args);
    }
}