package com.upworkapp.model;

import java.util.Set;

public class Freelancer {
	private String name;
	private String title;
	private Double charges;
	private String location;
	private String successRate;
	public Freelancer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Freelancer(String name, String title, Double charges, String location, String successRate) {
		super();
		this.name = name;
		this.title = title;
		this.charges = charges;
		this.location = location;
		this.successRate = successRate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getCharges() {
		return charges;
	}
	public void setCharges(Double charges) {
		this.charges = charges;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSuccessRate() {
		return successRate;
	}
	public void setSuccessRate(String successRate) {
		this.successRate = successRate;
	}
	@Override
	public String toString() {
		return "Freelancer [name=" + name + ", title=" + title + ", charges=" + charges + ", location=" + location
				+ ", successRate=" + successRate + "]";
	}
	
	

}
