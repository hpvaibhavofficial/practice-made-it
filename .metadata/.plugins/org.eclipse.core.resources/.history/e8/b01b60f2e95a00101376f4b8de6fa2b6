package com.vb.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	int roll;
	
	String sname;
	String branch;
	String phone;
	Date dob;
	Integer marks;
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", sname=" + sname + ", branch=" + branch + ", phone=" + phone + ", dob=" + dob
				+ ", marks=" + marks + "]";
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
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
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public Student(int roll, String sname, String branch, String phone, Date dob, Integer marks) {
		super();
		this.roll = roll;
		this.sname = sname;
		this.branch = branch;
		this.phone = phone;
		this.dob = dob;
		this.marks = marks;
	}
	public Student() {
		super();
	}
	
	

}