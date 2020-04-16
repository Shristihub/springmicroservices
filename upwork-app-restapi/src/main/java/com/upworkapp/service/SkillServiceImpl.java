package com.upworkapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upworkapp.dao.SkillsDAO;
import com.upworkapp.model.Skills;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillsDAO skillsDAO;

	@Override
	public Skills getSkill(String skillType) {
		return skillsDAO.findBySkillType(skillType) ;
	}
	
}
