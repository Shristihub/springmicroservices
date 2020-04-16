package com.upworkapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UpworkEurekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpworkEurekaRegistryApplication.class, args);
	}

}
