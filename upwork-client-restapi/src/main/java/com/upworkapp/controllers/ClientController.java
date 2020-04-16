package com.upworkapp.controllers;

import java.awt.print.Book;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.upworkapp.model.Job;

@RestController
@RequestMapping("/client-service")
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;
	private final String BASEURL = "http://localhost:8081/jobs-service";
	private static final Logger log = LoggerFactory.getLogger(ClientController.class.getName());
	
	@GetMapping(value = "/jobs-by-level/{level}", 
			   produces = "application/json")
	public List<Job> searchByLevel(@PathVariable("level") 
	                 String level) {
		log.info("client service - search by level");
		String url = BASEURL + "/jobs/level/" + level;
		List<Job> jobList = restTemplate.getForObject(url, List.class);
		return jobList;
	}
	@GetMapping(value = "/jobs-by-cost/{mincost}/{maxcost}", 
			   produces = "application/json")
	public List<Job> searchByCost(
			@PathVariable("mincost")String mincost,
			@PathVariable("maxcost")String maxcost) {
		log.info("client service - search by cost");
		String url = BASEURL + "/jobs/cost/" + mincost+"/"+maxcost;
		List<Job> jobList = restTemplate.getForObject(url, List.class);
		return jobList;
	}
	@GetMapping(value = "/all-jobs", 
			   produces = "application/json")
	public List<Job> showAllJobs(){
		log.info("client service - search by cost");
		String url = BASEURL + "/jobss";
		List<Job> jobList = restTemplate.getForObject(url, List.class);
		return jobList;
	}

}
