package com.training.courier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CourierApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourierApplication.class, args);
	}

}
