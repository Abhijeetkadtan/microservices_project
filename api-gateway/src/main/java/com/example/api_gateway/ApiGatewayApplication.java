package com.example.api_gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		log.info("API Gateway started and routing is enabled");

		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
