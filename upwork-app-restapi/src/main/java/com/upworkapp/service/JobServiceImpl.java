package com.upworkapp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upworkapp.dao.JobDAO;
import com.upworkapp.model.Job;
import com.upworkapp.model.Skills;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobDAO jobDAO;
	@Override
	public void addJob(Job job) {
		
		jobDAO.save(job);
	}

	@Override
	public List<Job> searchBySkills(Set<Skills> skills) {
		
		return jobDAO.findBySkillSet(skills);
	}

	@Override
	public List<Job> searchByCost(int minCost, int maxCost) {
		return jobDAO.findByMinCostAndMaxCost(minCost, maxCost);
	}

	@Override
	public List<Job> searchByLevel(String level) {
		return jobDAO.findByLevel(level);
	}

	@Override
	public void deleteJob(Job job) {
		jobDAO.delete(job);
		
	}

	@Override
	public void editJob(Job job) {
		jobDAO.save(job);
	}

	@Override
	public Job getJobById(int jobId) {
		return jobDAO.getOne(jobId);
	}

	@Override
	public List<Job> showAllJobs() {
		List<Job> jobList = jobDAO.findAll(); 
		System.out.println(jobList);
		return jobList;
	}

}
