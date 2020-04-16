package com.upworkapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skillseq")
	//@SequenceGenerator(name = "skillseq", sequenceName = "SKILLS_SEQ")

	private Integer skillsId;
	@Column(name = "skilltype")
	private String skillType;
	@ManyToMany(cascade= {
			CascadeType.PERSIST,
			CascadeType.MERGE
			},
			fetch=FetchType.LAZY,
			mappedBy="skillSet")
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
