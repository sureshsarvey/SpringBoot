package com.boot.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.boot.database"})
public class MultiDatebaseConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDatebaseConfigurationApplication.class, args);
	}

}
