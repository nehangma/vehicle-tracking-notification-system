package com.example.locationconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LocationConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationConsumerApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplte() {
		return new RestTemplate();
	}

}
