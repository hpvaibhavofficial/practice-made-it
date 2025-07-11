package com.hcl.todo.service;

import java.util.List;

import com.hcl.todo.model.Todo;

import jakarta.transaction.Transactional;

public interface TodoService {

	List<Todo> findAllByUsername(String username);
	Todo addTodo(String username,Todo todo);
	Todo UpdateTodo(Todo todo);

}