package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;
	private String name;
	private String department;

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Test(int testId, String name, String department) {
		super();
		this.testId = testId;
		this.name = name;
		this.department = department;
	}

	public Test() {

	}

}
