package com.dq.daoyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan( basePackages = {"com.dq.daoyuan.admin.dao"})
public class DaoyuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoyuanApplication.class, args);
    }

}
