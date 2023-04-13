package com.greedy.datatests.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.datatests.employee.dto.DepartmentDTO;
import com.greedy.datatests.employee.dto.EmployeeDTO;
import com.greedy.datatests.employee.dto.JobDTO;
import com.greedy.datatests.employee.dto.SalLevelDTO;
import com.greedy.datatests.employee.entity.Department;
import com.greedy.datatests.employee.entity.Employee;
import com.greedy.datatests.employee.entity.Job;
import com.greedy.datatests.employee.entity.SalLevel;
import com.greedy.datatests.employee.repository.DeptRepository;
import com.greedy.datatests.employee.repository.EmpRepository;
import com.greedy.datatests.employee.repository.JobRepository;
import com.greedy.datatests.employee.repository.SalLevelRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpService {
	
	private final EmpRepository empRepository;
	private final DeptRepository deptRepository;
	private final JobRepository jobRepository;
	private final SalLevelRepository salLevelRepository;
	private final ModelMapper modelMapper;
	
	public EmpService(EmpRepository empRepository, DeptRepository deptRepository, 
			JobRepository jobRepository, SalLevelRepository salLevelRepository , ModelMapper modelMapper) {
		
		this.empRepository = empRepository;
		this.deptRepository = deptRepository;
		this.jobRepository = jobRepository;
		this.salLevelRepository = salLevelRepository;
		this.modelMapper = modelMapper;
	}
	
	/*사원정보 전체 조회*/
	public List<EmployeeDTO> findAllEmpList() {
		
		List<Employee> empList = empRepository.findAll(Sort.by("empId").ascending());
		
		return empList.stream().map(emp -> modelMapper.map(emp, EmployeeDTO.class)).collect(Collectors.toList());
		
	}

	/* 페이징 처리*/
	public Page<EmployeeDTO> findAllEmpListPaging(Pageable pageable) {
		
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, 
							5, 
							Sort.by("empId").descending());
		
		Page<Employee> empList = empRepository.findAll(pageable);
		
		return empList.map(emp -> modelMapper.map(emp, EmployeeDTO.class));
	}

	/* 부서 전체 조회*/
	public List<DepartmentDTO> findAllDept() {
			
		List<Department> deptList = deptRepository.findAllDept();
		
		return deptList.stream().map(dept -> modelMapper.map(dept, DepartmentDTO.class)).collect(Collectors.toList());
	}

	/* 직급 전체 조회*/	
	public List<JobDTO> findAlljob() {
		
		List<Job> jobList = jobRepository.findAllJob();
		
		return jobList.stream().map(job -> modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
	}

	/* 급여 등급 전체 조회*/
	public List<SalLevelDTO> findAllSalLevel() {
		
		List<SalLevel> salList = salLevelRepository.findAllSalLevel();
		
		return salList.stream().map(sal -> modelMapper.map(sal, SalLevelDTO.class)).collect(Collectors.toList());
	}
	/* 신입 사원 등록 */
	@Transactional
	public void registNewEmp (EmployeeDTO emp) {
		
		empRepository.save(modelMapper.map(emp, Employee.class));
	}

	/* 사원번호로 사원정보 조회*/
	public EmployeeDTO findByEmpId(String empId) {
		
		Employee foundEmp = empRepository.findById(empId).orElseThrow(IllegalArgumentException::new);
		
		return modelMapper.map(foundEmp, EmployeeDTO.class);
	}

	/* 사원 정보 수정 */
	@Transactional
	public void modifyEmp(EmployeeDTO emp) {
		
		Employee foundEmp = empRepository.findById(emp.getEmpId()).orElseThrow(IllegalArgumentException::new);
		Department founDept = deptRepository.findById(emp.getDept().getDeptId()).orElseThrow(IllegalArgumentException::new);
		Job foundJob = jobRepository.findById(emp.getJob().getJobCode()).orElseThrow(IllegalArgumentException::new);
		SalLevel foundSalLevel = salLevelRepository.findById(emp.getSalLevel().getSalLevel()).orElseThrow(IllegalArgumentException::new);
		
		
		log.info("[Service] modifyEmp : {}",emp);
		foundEmp.setEmpName(emp.getEmpName());
		foundEmp.setDept(founDept);
		foundEmp.setJob(foundJob);
		foundEmp.setSalLevel(foundSalLevel);
		foundEmp.setEntYn(emp.getEntYn());
		if(emp.getEntYn().equals("Y")) {
			foundEmp.setEntDate(emp.getEntDate());
		}
		
	}
	
	/* 사원 정보 삭제 */
	@Transactional
	public void deleteEmp(String empId) {
		empRepository.deleteById(empId);
		
	}
	
	/* 사원 이름으로 조회(Query Method)*/
	public List<EmployeeDTO> SearchEmpId(String empId){
		
		List<Employee> empList = empRepository.findByEmpNameContaining(empId);
		
		log.info("[Service] SearchEmpId : {}",empList);	
		return empList.stream().map(emp -> modelMapper.map(emp, EmployeeDTO.class)).collect(Collectors.toList());
	}
	
	
	
	

}
