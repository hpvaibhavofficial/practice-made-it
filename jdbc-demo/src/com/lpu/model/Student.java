package com.lpu.model;

public class Student {
	private int roll;
	private String name;
	private String branch;
	private String phone;

	
	
	public Student(int roll, String name, String branch, String phone) {
		super();
		this.roll = roll;
		this.name = name;
		this.branch = branch;
		this.phone = phone;
	}

	public Student() {
		super();
	}
	

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", branch=" + branch + ", phone=" + phone + "]";
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public static void main(String [] args) {
		
	}
}
