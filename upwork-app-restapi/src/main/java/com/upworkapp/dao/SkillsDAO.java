package com.upworkapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upworkapp.model.Skills;

@Repository
public interface SkillsDAO extends JpaRepository<Skills, Integer>{
	Skills findBySkillType(String skillType);
}
