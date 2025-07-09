package com.vb.lib.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Book {

	@SequenceGenerator(name= "bookidseq",initialValue =10, allocationSize=1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int bid;
	String title;
	String author;
	Double price;
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", author=" + author + ", prince=" + price + "]";
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
	public Double getPrince() {
		return price;
	}
	public void setPrince(Double prince) {
		this.price = prince;
	}
	
	
	
}
