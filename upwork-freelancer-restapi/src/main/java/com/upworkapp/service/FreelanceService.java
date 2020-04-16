package com.upworkapp.service;

import java.util.List;

import com.upworkapp.model.Freelancer;

public interface FreelanceService {

	List<Freelancer> showByLocation(String location);

	List<Freelancer> showByCharges(double charges);

}
