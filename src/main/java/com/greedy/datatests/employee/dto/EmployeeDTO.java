package com.greedy.datatests.employee.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class EmployeeDTO {
	

	private String empId;
	private String empName;
	private String empNo;
	private DepartmentDTO dept;
	private JobDTO job;
	private SalLevelDTO salLevel;
	@DateTimeFormat(pattern = "yyyy-MM-dd") /* input type date로 받는 경우 String 타입으로 넘어와 date 타입으로 포맷해주는 어노테이션*/
	private Date hireDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entDate;
	private String entYn;
	
	public EmployeeDTO() {}

	public EmployeeDTO(String empId, String empName, String empNo, DepartmentDTO dept, JobDTO job, SalLevelDTO salLevel,
			Date hireDate, Date entDate, String entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.dept = dept;
		this.job = job;
		this.salLevel = salLevel;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public DepartmentDTO getDept() {
		return dept;
	}

	public void setDept(DepartmentDTO dept) {
		this.dept = dept;
	}

	public JobDTO getJob() {
		return job;
	}

	public void setJob(JobDTO job) {
		this.job = job;
	}

	public SalLevelDTO getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(SalLevelDTO salLevel) {
		this.salLevel = salLevel;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getEntDate() {
		return entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	public String getEntYn() {
		return entYn;
	}

	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", dept=" + dept + ", job="
				+ job + ", salLevel=" + salLevel + ", hireDate=" + hireDate + ", entDate=" + entDate + ", entYn="
				+ entYn + "]";
	}

	
	
	

}
