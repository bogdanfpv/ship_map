package com.bdago.ShipServer;

import com.bdago.ShipServer.time.StartTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.bdago.ShipServer.time.TimeService;

import java.time.LocalDateTime;

@EnableJpaRepositories("com.bdago.*")
@ComponentScan(basePackages = { "com.bdago.ShipServer.*" })
@EntityScan("com.bdago.ShipServer.*")
@SpringBootApplication

public class ShipServerApplication {

	@Autowired
	private TimeService timeService;

	@Autowired
	private StartTimeService startTimeService;

	public static void main(String[] args) {
		SpringApplication.run(ShipServerApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return args -> {
			LocalDateTime start = LocalDateTime.now();
			startTimeService.setStartLocalDateTime(start);
		};
	}
}