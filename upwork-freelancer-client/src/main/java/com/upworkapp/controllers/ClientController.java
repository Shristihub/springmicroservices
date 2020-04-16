package com.upworkapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.upworkapp.model.Freelancer;

@RestController
@RequestMapping("client-service")
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient ;
	
	private String getBaseURL() {
		InstanceInfo instanceInfo = 
		eurekaClient.getNextServerFromEureka("FREELANCER-SERVICE", false);
		String appName = instanceInfo.getAppName();
		
		System.out.println(instanceInfo.getPort());
		String uri = "http://"+appName+ "/freelance-service";
		System.out.println(uri);
		return uri;
	}

	@GetMapping("/freelancers/location/{location}")
	public List<Freelancer> showbyLocation(@PathVariable String location) {
		String url = getBaseURL() + "/freelancers-by-location/" + location;
		return restTemplate.getForObject(url, List.class);

	}

	@GetMapping("/freelancers/charges/{charges}")
	public List<Freelancer> showByCharges(@PathVariable double charges) {
		String url = getBaseURL() + "/freelancers-by-charges/" + charges;
		List<Freelancer> freelancerList = (List<Freelancer>) restTemplate.getForObject(url, List.class);
		/*
		 * .stream() .sorted((one,two)->one.compareTo(two.getName()))
		 * .collect(Collectors.toList());
		 */
		return freelancerList;
	}

}
