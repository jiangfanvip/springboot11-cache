package com.jiangfan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Springboot11CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot11CacheApplication.class, args);
    }

}
