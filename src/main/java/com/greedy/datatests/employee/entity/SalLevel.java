package com.greedy.datatests.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SAL_GRADE")
public class SalLevel {
	
	@Id
	@Column(name="SAL_LEVEL")
	private String salLevel;
	
	@Column(name="MIN_SAL")
	private int minSal;
	
	@Column(name="MAX_SAL")
	private int maxSal;
	
	public SalLevel() {}

	public SalLevel(String salLevel, int minSal, int maxSal) {
		super();
		this.salLevel = salLevel;
		this.minSal = minSal;
		this.maxSal = maxSal;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public int getMinSal() {
		return minSal;
	}

	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}

	public int getMaxSal() {
		return maxSal;
	}

	public void setMaxSal(int maxSal) {
		this.maxSal = maxSal;
	}

	@Override
	public String toString() {
		return "SalLevel [salLevel=" + salLevel + ", minSal=" + minSal + ", maxSal=" + maxSal + "]";
	}
	
	

	
	
}
