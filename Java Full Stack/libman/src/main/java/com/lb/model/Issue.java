package com.lb.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	int issueid;
	
	@ManyToOne
	@JoinColumn(name="bookid")
	Book book;
	
	@ManyToOne
	@JoinColumn(name="studentid")
	private Student student;
	private Date issuedate;
	private Date returndate;
	private Date duedate;
	private Boolean returned;
	private Double fine;
	
	
	public Issue() {
		// TODO Auto-generated constructor stub
	}


	public Issue(Book book, Student student, Date issuedate, Date returndate, Date duedate, Boolean returned,
			Double fine) {
		super();
		this.book = book;
		this.student = student;
		this.issuedate = issuedate;
		this.returndate = returndate;
		this.duedate = duedate;
		this.returned = returned;
		this.fine = fine;
	}


	public int getIssueid() {
		return issueid;
	}


	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Date getIssuedate() {
		return issuedate;
	}


	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}


	public Date getReturndate() {
		return returndate;
	}


	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}


	public Date getDuedate() {
		return duedate;
	}


	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}


	public Boolean getReturned() {
		return returned;
	}


	public void setReturned(Boolean returned) {
		this.returned = returned;
	}


	public Double getFine() {
		return fine;
	}


	public void setFine(Double fine) {
		this.fine = fine;
	}
	
	
}
