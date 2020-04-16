package com.upworkapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.upworkapp.model.Freelancer;

@Component
public class IFeignServiceImpl implements IFeignService {

	@Override
	public List<Freelancer> showbyLocation(String location) {
		System.out.println("fall back for au");
		return new ArrayList<>();
	}

	@Override
	public List<Freelancer> showByCharges(double charges) {
		return new ArrayList<>();
	}

}
