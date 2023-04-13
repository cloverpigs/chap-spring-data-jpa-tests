package com.greedy.datatests.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.datatests.employee.entity.Employee;


public interface EmpRepository extends JpaRepository<Employee, String>{

	
	/* 전달 받은 문자열(이름)로 사원정보 검색 */
	List<Employee> findByEmpNameContaining(String empName);
}
