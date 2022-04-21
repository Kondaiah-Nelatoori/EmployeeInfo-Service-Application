package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeInfoApplication {

	@Bean
	public WebClient.Builder myWebclient(){
		return  WebClient.builder();
	}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeInfoApplication.class, args);
	}

}
