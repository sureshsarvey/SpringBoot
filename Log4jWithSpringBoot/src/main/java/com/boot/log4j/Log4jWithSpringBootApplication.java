package com.boot.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4jWithSpringBootApplication {

	private static final Logger LOGGER = LogManager.getLogger(Log4jWithSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Log4jWithSpringBootApplication.class, args);
		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
	}

}
