package com.vb.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int isid;
	int bid;
	int roll;
	Date isDate,expretdate;
	Double fine;
	@Override
	public String toString() {
		return "Issue [isid=" + isid + ", bid=" + bid + ", roll=" + roll + ", isDate=" + isDate + ", expretdate="
				+ expretdate + ", fine=" + fine + "]";
	}
	public int getIsid() {
		return isid;
	}
	public void setIsid(int isid) {
		this.isid = isid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public Date getIsDate() {
		return isDate;
	}
	public void setIsDate(Date isDate) {
		this.isDate = isDate;
	}
	public Date getExpretdate() {
		return expretdate;
	}
	public void setExpretdate(Date expretdate) {
		this.expretdate = expretdate;
	}
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
	public Issue(int isid, int bid, int roll, Date isDate, Date expretdate, Double fine) {
		super();
		this.isid = isid;
		this.bid = bid;
		this.roll = roll;
		this.isDate = isDate;
		this.expretdate = expretdate;
		this.fine = fine;
	}
	public Issue() {
		// TODO Auto-generated constructor stub
	}
	
}	
