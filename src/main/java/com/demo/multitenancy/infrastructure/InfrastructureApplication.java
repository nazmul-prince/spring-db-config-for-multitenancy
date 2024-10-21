package com.demo.multitenancy.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.demo.multitenancy.infrastructure",
        "com.demo.multitenancy.infradetails.persistence"

})
@EnableJpaRepositories(basePackages = {
        "com.demo.multitenancy.infradetails.persistence.repository"
})
@EntityScan(basePackages = {
        "com.demo.multitenancy.infradetails.persistence.entity"
})
public class InfrastructureApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfrastructureApplication.class, args);
    }

}
