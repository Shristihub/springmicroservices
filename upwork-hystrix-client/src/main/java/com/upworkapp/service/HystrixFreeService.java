package com.upworkapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.upworkapp.model.Freelancer;

@Service
public class HystrixFreeService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public final String BASEURL = 
			"http://localhost:8020/client-service";

	
	@HystrixCommand(fallbackMethod="fallbackLocation")
	public List<Freelancer> showbyLocation(String location) {
		String url = BASEURL + "/freelancers/location/" + location;
		return restTemplate.getForObject(url, List.class);
	}
	public List<Freelancer> fallbackLocation(String location) {
		return new ArrayList<>();
	}
	@HystrixCommand(fallbackMethod="fallbackCharges")
	public List<Freelancer> showByCharges(double charges) {
		String url = BASEURL + "/freelancers/charges/" + charges;
		List<Freelancer> freelancerList = (List<Freelancer>) restTemplate.getForObject(url, List.class);
		return freelancerList;
	}
	public List<Freelancer> fallbackCharges(double charges) {
		return new ArrayList<>();
	}


}
