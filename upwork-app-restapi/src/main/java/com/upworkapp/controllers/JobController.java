package com.upworkapp.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upworkapp.exception.NoJobsFoundException;
import com.upworkapp.model.Job;
import com.upworkapp.model.Skills;
import com.upworkapp.service.JobService;
import com.upworkapp.service.SkillService;

@RestController
@RequestMapping("/jobs-service")
public class JobController {

	@Autowired
	JobService jobService;
	
	@Autowired
	SkillService skillService;
	@GetMapping("/jobs")
	public String postJob() {
		Job job = new Job();
		job.setTitle("Debug javascript");
		job.setCost(1200);
		job.setDuration("10 days");
		job.setLevel("Entry");
		job.setJobId(123);
		job.getSkillSet();
//		Skills skillOne = new Skills(201,"Node");
//		skillOne.getJobList().add(job);
//		Skills skillTwo = new Skills(202,"HTML");
//		skillTwo.getJobList().add(job);
//		job.getSkillSet().add(skillOne);
//		job.getSkillSet().add(skillTwo);
		
		
		//Skills newSkill = skillService.getSkill(j);
	


		return  "success";
	}
	@GetMapping(value = "/jobss")
	public List<Job> getAllJobs() {
		List<Job> jobList = jobService.showAllJobs();
		return jobList;
	}	
	@GetMapping(value = "/jobs/level/{level}")
	public List<Job> getJobsByLevel(@PathVariable("level")String level) {
		List<Job> jobList = new ArrayList<>();;
		try {
			jobList = jobService.searchByLevel(level);
		} catch (NoJobsFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobList;
	}
	@GetMapping(value = "/jobs/cost/{mincost}/{maxcost}")
	public List<Job> getJobsByCost(@PathVariable("mincost")int minCost,
							@PathVariable("maxcost")int maxCost) {
		List<Job> jobList = new ArrayList<>();
		try {
			jobList = jobService.searchByCost(minCost, maxCost);
		} catch (NoJobsFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobList;
	}
	@GetMapping(value = "/jobs/id/{id}")
	public Job getJobsById(@PathVariable("id")Integer jobId) {
		Job job = jobService.getJobById(jobId);
		return job;
	}
	@GetMapping(value = "/jobs/skills/{skills}")
	public List<Job> getJobsBySkills(@PathVariable List<String> skills) {
		System.out.println(skills);
		Set<Skills> skillset = new HashSet<Skills>(); 
        for (Skills x : skillset) 
        	skillset.add(x);
		List<Job> jobList = new ArrayList<>();;
		try {
			jobList = jobService.searchBySkills(skillset);
		} catch (NoJobsFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobList;
	}
	@GetMapping(value = "/jobs/delete")
	public void deleteJob(Job job) {
		jobService.deleteJob(job);
	}
}
