package com.vx.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	int eid;
	String name;
    String email;
    String department;
    String phoneNumber;
    String designation;
    Double salary;
    LocalDate joinDate;
    
    @OneToOne @JoinColumn(name  = "parking_id")
    Parking parking;

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", phoneNumber=" + phoneNumber + ", designation=" + designation + ", salary=" + salary + ", joinDate="
				+ joinDate + ", parking=" + parking + "]";
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public Employee(int eid, String name, String email, String department, String phoneNumber, String designation,
			Double salary, LocalDate joinDate, Parking parking) {
		super();
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.department = department;
		this.phoneNumber = phoneNumber;
		this.designation = designation;
		this.salary = salary;
		this.joinDate = joinDate;
		this.parking = parking;
	}
    public Employee() {
		// TODO Auto-generated constructor stub
	}
}
