package com.greedy.datatests.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.datatests.employee.entity.SalLevel;

public interface SalLevelRepository extends JpaRepository<SalLevel, String>{

	@Query(value="SELECT s FROM SalLevel s ORDER BY salLevel DESC")
	public List<SalLevel> findAllSalLevel();

}
