package com.greedy.datatests.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.datatests.employee.entity.Employee;
import com.greedy.datatests.employee.entity.Job;

public interface JobRepository extends JpaRepository<Job, String>{

	@Query(value="SELECT JOB_CODE, JOB_NAME FROM JOB ORDER BY JOB_CODE DESC"
			, nativeQuery = true)
	public List<Job> findAllJob();
	
	/* 전달 받은 문자열(이름)로 사원정보 검색 */
	List<Job> findByjobNameContaining(String jobName);

}
