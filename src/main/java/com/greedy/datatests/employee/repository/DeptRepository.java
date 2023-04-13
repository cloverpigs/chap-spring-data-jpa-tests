package com.greedy.datatests.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.datatests.employee.entity.Department;

public interface DeptRepository extends JpaRepository<Department, String>{

	@Query(value="SELECT d FROM Department d ORDER BY deptId ASC")
	public List<Department> findAllDept();
	
	/* 전달 받은 문자열(이름)로 사원정보 검색 */
	List<Department> findBydeptNameContaining(String deptName);

}
