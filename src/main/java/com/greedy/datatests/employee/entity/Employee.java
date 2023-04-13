package com.greedy.datatests.employee.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="EMPLOYEE")
@DynamicInsert /*insert시 null인 경우 필드 제외 ( defalut값 적용시 값이 null이 아닌 아무값도 안들어가가야 적용된다.)*/
@DynamicUpdate /*update시 null인 경우 필드 제외 ( defalut값 적용시 값이 null이 아닌 아무값도 안들어가가야 적용된다.)*/
public class Employee {
	
	@Id
	@Column(name="EMP_ID")
	private String empId;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="EMP_NO")
	private String empNo;
	
	@JoinColumn(name="DEPT_CODE")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Department dept;
	
	@JoinColumn(name="JOB_CODE")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Job job;
	
	@JoinColumn(name="SAL_LEVEL")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private SalLevel salLevel;
	
	@Column(name="HIRE_DATE")
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	
	@Column(name="ENT_DATE")
	@Temporal(TemporalType.DATE)
	private Date entDate;
	
	@Column(name="ENT_YN")
	private String entYn;
	
	public Employee() {}

	public Employee(String empId, String empName, String empNo, Department dept, Job job, SalLevel salLevel,
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

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public SalLevel getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(SalLevel salLevel) {
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
		return "Employee [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", dept=" + dept + ", job="
				+ job + ", salLevel=" + salLevel + ", hireDate=" + hireDate + ", entDate=" + entDate + ", entYn="
				+ entYn + "]";
	}


	
	
	

}
