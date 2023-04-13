package com.greedy.datatests.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.datatests.employee.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, String>{

}
