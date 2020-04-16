package com.upworkapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.upworkapp.model.Freelancer;
import com.upworkapp.service.HystrixFreeService;

@RestController
@RequestMapping("hystrix-service")
public class HystrixController {

	@Autowired
	HystrixFreeService hystrixService;

	@GetMapping("/hystrix-location/{location}")
	public List<Freelancer> showbyLocation(@PathVariable String location) {
	 return hystrixService.showbyLocation(location);

	}

	@GetMapping("/hystrix-charges/{charges}")
	public List<Freelancer> showByCharges(@PathVariable double charges) {
		return hystrixService.showByCharges(charges);
	}

}
