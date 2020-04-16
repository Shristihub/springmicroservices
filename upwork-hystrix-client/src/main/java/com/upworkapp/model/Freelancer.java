package com.upworkapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Freelancer {
	private String name;
	private String title;
	private Double charges;
	private String location;
	private String successRate;

}
