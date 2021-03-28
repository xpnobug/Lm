package com.abc.monster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
@MapperScan("com.abc.monster.mapper")
public class LmonsterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmonsterApplication.class, args);
    }

}
