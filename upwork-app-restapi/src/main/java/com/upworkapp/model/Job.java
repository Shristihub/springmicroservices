package com.upworkapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Job {

	private String title;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	        // generator="jobseq")
	//	@SequenceGenerator(name="jobseq",sequenceName="JOB_SEQ")
	private Integer jobId;
	private String description;
	private Integer cost;
	private String level;
	private String duration;
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {
				CascadeType.PERSIST,
				CascadeType.MERGE
			})
	@JoinTable(name="jobs_skills",
	           joinColumns= {@JoinColumn(name="JOB_ID")},
	           inverseJoinColumns= {@JoinColumn(name="SKILLS_ID")}
	           )
	@JsonIgnore
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
