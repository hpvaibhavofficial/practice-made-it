package com.lb.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int bid;
	
	private String name;
	private String author;
	private String publisher;
	private String language;
	private String genre;
	private Integer pubyear;
	private String isbn;
	private Integer totalcopies;
	private Integer availablecopies;
	
	@OneToMany(mappedBy = "book")
	private List<Issue> issues = new ArrayList<>(); 
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book( String name, String author, String publisher, String language, String genre, Integer pubYear,
			String isbn, Integer totalcopies, Integer availablecopies) {
		super();
		
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.language = language;
		this.genre = genre;
		this.pubyear = pubYear;
		this.isbn = isbn;
		this.totalcopies = totalcopies;
		this.availablecopies = availablecopies;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getPubYear() {
		return pubyear;
	}

	public void setPubYear(Integer pubYear) {
		this.pubyear = pubYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getTotalcopies() {
		return totalcopies;
	}

	public void setTotalcopies(Integer totalcopies) {
		this.totalcopies = totalcopies;
	}

	public Integer getAvailablecopies() {
		return availablecopies;
	}

	public void setAvailablecopies(Integer availablecopies) {
		this.availablecopies = availablecopies;
	}
	
	
}
