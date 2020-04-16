package com.upworkapp.model;

import java.util.HashSet;
import java.util.Set;

public class Job {

	private String title;
	private Integer jobId;
	private String description;
	private Integer cost;
	private String level;
	private String duration;
	private Set<Skills> skillSet = new HashSet<>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Set<Skills> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(Set<Skills> skillSet) {
		this.skillSet = skillSet;
	}
	@Override
	public String toString() {
		return "Job [title=" + title + ", jobId=" + jobId + ", description=" + description + ", cost=" + cost
				+ ", level=" + level + ", duration=" + duration + ", expertise=" + skillSet + "]";
	}
	
	
	
	
	
}
