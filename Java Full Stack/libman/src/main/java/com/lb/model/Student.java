package com.lb.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int regno;
	
	private String name;
	private String email;
	private String phone;
	private Date dob;
	private String gender;
	private String address;
	private String branch;
	private Double gpa;
	private String status;
	
	@OneToMany(mappedBy = "student")
	private List<Issue> issues = new ArrayList();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [regno=" + regno + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob=" + dob
				+ ", gender=" + gender + ", address=" + address + ", branch=" + branch + ", gpa=" + gpa + ", status="
				+ status + "]";
	}

	public Student( String name, String email, String phone, Date dob, String gender, String address,
			String branch, Double gpa, String status) {
		super();
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.branch = branch;
		this.gpa = gpa;
		this.status = status;
	}
	
	
	

}
