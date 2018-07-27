package com.restfulproject.dhrubo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackageClasses = {com.restfulproject.dhrubo.springRestfulApplication.class})
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class springRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(springRestfulApplication.class, args);
    }
}
