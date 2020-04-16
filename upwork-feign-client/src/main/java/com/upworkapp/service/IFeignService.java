package com.upworkapp.service;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.upworkapp.model.Freelancer;

@FeignClient(value="FREELANCER-SERVICE")
public interface IFeignService {
	
	@GetMapping("/freelance-service/freelancers-by-location/{location}")
	public List<Freelancer> showbyLocation(@PathVariable String location);
		
	@GetMapping("/freelance-service/freelancers-by-charges/{charges}")
	public List<Freelancer> showByCharges(@PathVariable double charges);
		
	
}
