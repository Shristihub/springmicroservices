package com.upworkapp.model;

import java.util.HashSet;
import java.util.Set;

public class Skills {

	private Integer skillsId;
	private String skillType;
	private Set<Job> jobList = new HashSet<>();
	
	public Skills() {
		super();
	}

	public Set<Job> getJobList() {
		return jobList;
	}

	public void setJobList(Set<Job> jobList) {
		this.jobList = jobList;
	}


	public Skills(Integer skillsId, String skillType) {
		super();
		this.skillsId = skillsId;
		this.skillType = skillType;
	}

	public Integer getSkillsId() {
		return skillsId;
	}

	public void setSkillsId(Integer skillsId) {
		this.skillsId = skillsId;
	}

	public String getSkillType() {
		return skillType;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

	@Override
	public String toString() {
		return "Skills [skillsId=" + skillsId + ", skillType=" + skillType + "]";
	}

	

}
