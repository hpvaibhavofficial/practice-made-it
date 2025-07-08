package com.vb.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("faculty")
public class Faculty extends Person{
	
	Integer facid;
	String designation;
	public Faculty(int pid, String name, String phone, Integer facid, String designation) {
		super(pid, name, phone);
		this.facid = facid;
		this.designation = designation;
	}
	public Faculty() {
		super();
	}
	public Integer getFacid() {
		return facid;
	}
	public void setFacid(Integer facid) {
		this.facid = facid;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Faculty [facid=" + facid + ", designation=" + designation + ", pid=" + pid + ", name=" + name
				+ ", phone=" + phone + "]";
	}
	
}