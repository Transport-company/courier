package com.training.courier;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableScheduling
@OpenAPIDefinition(info = @Info(title = "Courier microservice"))
public class CourierApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourierApplication.class, args);
    }
}
