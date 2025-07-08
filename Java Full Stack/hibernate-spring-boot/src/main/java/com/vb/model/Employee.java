package com.vb.model;


import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	int empid;
	String name,designation;
	Integer mgrid;
	
	@ManyToOne
	Department department;
	

	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", designation=" + designation + ", mgrid=" + mgrid
				+ ", department=" + department + "]";
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getMgrid() {
		return mgrid;
	}

	public void setMgrid(Integer mgrid) {
		this.mgrid = mgrid;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	
	public Employee(int empid, String name, String designation, Integer mgrid, Department department) {
		super();
		this.empid = empid;
		this.name = name;
		this.designation = designation;
		this.mgrid = mgrid;
		this.department = department;
	}

	public Employee() {
		
	}
}
