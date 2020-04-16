package com.upworkapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upworkapp.model.Freelancer;
import com.upworkapp.service.FreelanceService;

@RestController
@RequestMapping("freelance-service")
public class FreelanceController {

	@Autowired
	FreelanceService freelanceService;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/freelancers-by-location/{location}")
	public List<Freelancer> showbyLocation(@PathVariable String location) {
		return freelanceService.showByLocation(location);
	}
	@GetMapping("/freelancers-by-charges/{charges}")
	public List<Freelancer> showByCharges(@PathVariable double charges) {
		return freelanceService.showByCharges(charges);
	}
	
}
