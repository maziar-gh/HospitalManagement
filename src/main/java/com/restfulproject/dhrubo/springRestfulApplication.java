package com.restfulproject.dhrubo;

import com.restfulproject.dhrubo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;


@SpringBootApplication(scanBasePackageClasses = {com.restfulproject.dhrubo.springRestfulApplication.class} ,exclude = DataSourceAutoConfiguration.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class springRestfulApplication {



    public static void main(String[] args) {
        SpringApplication.run(springRestfulApplication.class, args);
    }
}
