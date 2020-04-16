package com.upworkapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upworkapp.model.Freelancer;
import com.upworkapp.service.IFeignService;

@RestController
@RequestMapping("feign-service")
public class FeignController {


	@Autowired
	private IFeignService feignService ;
	
	@GetMapping("/freelancers/location/{location}")
	public List<Freelancer> showbyLocation(@PathVariable String location) {
		return feignService.showbyLocation(location);

	}

	@GetMapping("/freelancers/charges/{charges}")
	public List<Freelancer> showByCharges(@PathVariable double charges) {
		return feignService.showByCharges(charges);
	}

}
