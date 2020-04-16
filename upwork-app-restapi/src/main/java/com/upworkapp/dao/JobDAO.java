package com.upworkapp.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upworkapp.model.Job;
import com.upworkapp.model.Skills;

@Repository
public interface JobDAO extends JpaRepository<Job, Integer>{
	List<Job> findByLevel(String level);
	
	//List<Job> findBySkillSet(Set<Skills> skills);
	List<Job> findBySkillSet(Set<Skills> skills);
	
	@Query("SELECT j FROM Job j WHERE j.cost> ?1 and j.cost< ?2")
//	List<Job> searchByBudget(@Param("min")int mincost,@Param("max")int maxcost);
	List<Job> findByMinCostAndMaxCost(int mincost,int maxcost);
}
