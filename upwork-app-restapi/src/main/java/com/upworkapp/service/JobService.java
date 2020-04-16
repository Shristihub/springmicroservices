package com.upworkapp.service;

import java.util.List;
import java.util.Set;

import com.upworkapp.exception.NoJobsFoundException;
import com.upworkapp.model.Job;
import com.upworkapp.model.Skills;

public interface JobService {
	void addJob(Job job);
	List<Job> showAllJobs();
	List<Job> searchBySkills(Set<Skills> skills) throws NoJobsFoundException;
	List<Job> searchByCost(int minCost, int maxCost) throws NoJobsFoundException;
	List<Job> searchByLevel(String level) throws NoJobsFoundException;
	void deleteJob(Job job);
	void editJob(Job job);
	Job getJobById(int jobId);
}
