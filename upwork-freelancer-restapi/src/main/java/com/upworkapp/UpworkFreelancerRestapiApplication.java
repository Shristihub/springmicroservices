package com.upworkapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UpworkFreelancerRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpworkFreelancerRestapiApplication.class, args);
	}

}
