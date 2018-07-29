package com.restfulproject.dhrubo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackageClasses = {com.restfulproject.dhrubo.RestfulApiApplication.class})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class RestfulApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApiApplication.class, args);
    }
}
