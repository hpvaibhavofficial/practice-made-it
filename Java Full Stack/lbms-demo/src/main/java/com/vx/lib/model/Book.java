package com.vx.lib.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookidseq")
	@SequenceGenerator(name = "bookidseq",sequenceName = "books_seq",initialValue = 1)
	int bid;
	
	@Column(nullable = false)
	String title;
	
	String author;
	String publisher;
	String language;
	Integer pubYear;
	Boolean isIssued;
	
	public Book() {
		
	}
	
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", language=" + language + ", pubYear=" + pubYear + ", isIssued=" + isIssued + "]";
	}



	public Book( String title, String author, String publisher, String language, Integer pubYear,
			Boolean isIssued) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.language = language;
		this.pubYear = pubYear;
		this.isIssued = isIssued;
	}
	
	public int getBid() {
		return bid;
	}
	
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Integer getPubYear() {
		return pubYear;
	}
	
	public void setPubYear(Integer pubYear) {
		this.pubYear = pubYear;
	}
	
	public Boolean getIsIssued() {
		return isIssued;
	}
	
	public void setIsIssued(Boolean isIssued) {
		this.isIssued = isIssued;
	}

}
