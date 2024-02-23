package com.bdago.ShipServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.bdago.*")
@ComponentScan(basePackages = { "com.bdago.ShipServer.*" })
@EntityScan("com.bdago.ShipServer.*")
@SpringBootApplication

public class ShipServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipServerApplication.class, args);
	}

}