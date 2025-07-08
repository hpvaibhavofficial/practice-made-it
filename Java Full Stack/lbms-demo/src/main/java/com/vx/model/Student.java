package com.vx.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ref_seq")
	@SequenceGenerator(name = "ref_seq", initialValue = 12210000, allocationSize = 1)
	int regno;
	
	@OneToOne
	@JoinColumn(name = "dept_id")
	Department department;
	
	
	String name;
	Integer roll;
	String address;
	Integer phone;
	String branch;
	Date dob;
	String email;
	Double gpa;
	String gender;
	String status;
	
	public Student() {
		
	}
	public Student(String name, Integer roll, String address, Integer phone, String branch, Date dob,
			String email, Double gpa, String gender, Department department, String status) {
		super();
	
		this.name = name;
		this.roll = roll;
		this.address = address;
		this.phone = phone;
		this.branch = branch;
		this.dob = dob;
		this.email = email;
		this.gpa = gpa;
		this.gender = gender;
		this.department = department;
		this.status = status;
	}
	
	public Integer getRegno() {
		return regno;
	}
	public void setRegno(Integer regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
