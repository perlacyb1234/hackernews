package com.cskaoyan.hackernews;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(exclude = DataSourceAutoConfiguration.class)*/
@MapperScan(basePackages = "com.cskaoyan.hackernews.mapper")
public class HackernewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackernewsApplication.class, args);
    }

}
