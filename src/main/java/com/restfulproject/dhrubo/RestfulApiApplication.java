package com.restfulproject.dhrubo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication(scanBasePackageClasses = {com.restfulproject.dhrubo.RestfulApiApplication.class})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class RestfulApiApplication {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(RestfulApiApplication.class, args);
    }
}
