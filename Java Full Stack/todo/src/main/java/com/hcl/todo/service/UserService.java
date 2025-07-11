package com.hcl.todo.service;

import com.hcl.todo.model.User;

public interface UserService {

	User findByUsername(String username);
	User addUser(User user);

}