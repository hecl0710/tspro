package com.venus.tspro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.venus.tspro.dao.sys")
public class TsproApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsproApplication.class, args);
    }

}
