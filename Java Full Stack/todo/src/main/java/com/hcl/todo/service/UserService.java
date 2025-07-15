package com.hcl.todo.service;

import java.util.List;
import java.util.Map;

import com.hcl.todo.model.User;

public interface UserService {

	User findByUsername(String username);
	User addUser(User user);
	List<User> findAll();
	boolean checkLogin(String username , String password);
	boolean remove(User user);
	User updateUser(User user);
	User patchUser(Map<String,String> map);
	

}