package com.upworkapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.upworkapp.model.Freelancer;
@Service
public class FreelanceServiceImpl implements FreelanceService {

	@Override
	public List<Freelancer> showByLocation(String location) {
		return showFreelancerList()
				.stream()
				.filter((freelancer)->freelancer.getLocation().equals(location))
				.sorted((one,two)->one.getName().compareTo(two.getName()))
				.collect(Collectors.toList());		
	}

	@Override
	public List<Freelancer> showByCharges(double charges) {
		return showFreelancerList()
				.stream()
				.filter((freelancer)->freelancer.getCharges()<charges)
				.sorted((one,two)->one.getName().compareTo(two.getName()))
				.collect(Collectors.toList());
	}

	private List<Freelancer> showFreelancerList(){
		return Arrays.asList(
			new Freelancer("Raju","Graphic designer", 1000.0,"India","80%andup"),
			new Freelancer("John","Android Expert", 3000.0,"Singapore","50%andup"),
			new Freelancer("Ranjini","Business Analyst", 500.0,"Malaysia","40%andup"),
			new Freelancer("Sam","Market Research", 1200.0,"Singapore","90%andup"),
			new Freelancer("Zeenath","Graphic designer", 700.0,"India","80%andup"),
			new Freelancer("Piyush","Python Developer", 800.0,"India","70%andup"),
			new Freelancer("Robin","Node", 2000.0,"London","60%andup"),
			new Freelancer("Helen","Graphic designer", 1000.0,"London","80%andup")
		  );
	}
}
