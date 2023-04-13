package com.greedy.datatests.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOB")
public class Job {
	
	@Id
	@Column(name="JOB_CODE")
	private String jobCode;
	
	@Column(name="JOB_NAME")
	private String jobName;
	
	public Job() {}

	public Job(String jobCode, String jobName) {
		super();
		this.jobCode = jobCode;
		this.jobName = jobName;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "Job [jobCode=" + jobCode + ", jobName=" + jobName + "]";
	}
	

}
