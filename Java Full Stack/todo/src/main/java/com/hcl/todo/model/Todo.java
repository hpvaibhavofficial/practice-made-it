package com.hcl.todo.model;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="todo")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int todoId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
	User user;
	
	private String description;
	@Column(name="tododate")
	private Date todoDate;
	private boolean completed;
	
	
	
	public int getTodoId() {
		return todoId;
	}
	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(Date todoDate) {
		this.todoDate = todoDate;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Todo(int todoId, User user, String description, Date todoDate, boolean completed) {
		super();
		this.todoId = todoId;
		this.user = user;
		this.description = description;
		this.todoDate = todoDate;
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", user=" + user + ", description=" + description + ", todoDate=" + todoDate
				+ ", completed=" + completed + "]";
	}
	public Todo() {
		super();
	}
	
	
	
}
