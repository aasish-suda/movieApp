package com.online.theatre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = "com.online.theatre.*")
@EnableJpaRepositories(basePackages = "com.online.theatre.*")
@EntityScan("com.online.theatre.entity")
@EnableEurekaClient
@EnableTransactionManagement
@SpringBootApplication
public class TheatreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreApplication.class, args);
	}

}
