package com.hcl.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.todo.model.Todo;
import com.hcl.todo.model.User;
import com.hcl.todo.repo.ToDoRepository;
import com.hcl.todo.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired 
	ToDoRepository todorepo;
	
	@Autowired
	UserRepository userrepo;
	
	
	@Transactional
	public List<Todo> findAllByUsername(String username)
	{	
		return todorepo.findAllByUsername((username));
	}
	
	@Override
	@Transactional
	public Todo addTodo(String username ,Todo todo) {
		Optional<User> opt = userrepo.findById(username);
		if(opt.isEmpty()) {
			//no user exists
			return null;
		}
		User user = opt.get();
		todo.setUser(user);
		Todo saved = todorepo.save(todo);
		return saved;
	}
	
	@Override
	@Transactional
	public Todo UpdateTodo(Todo todo) {
		Todo updated = todorepo.save(todo);
		return updated;
	}
	
	
}
