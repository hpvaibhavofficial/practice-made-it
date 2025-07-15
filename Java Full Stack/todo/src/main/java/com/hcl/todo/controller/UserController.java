package com.hcl.todo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.todo.model.User;
import com.hcl.todo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController //all methods of this class will return the object in the form of json
//@Controller


public class UserController {
	@Autowired
	UserService userservice;
	@GetMapping(path = "/user",produces = "application/json")
	//@ResponseBody
	public User getUser(@RequestParam("username")String username) {
		return userservice.findByUsername(username); // we have written @controoller and controller return name of view
		
	}
	
	@GetMapping("/users")
	public List<User> findAll()
	{
		return userservice.findAll();
	}
	
	@PostMapping(path  = "/user",consumes = "application/json",produces = "application/json")
	public User addUser(@RequestBody User user) {
		User added = userservice.addUser(user);
		
		return added;
	}
	
//	@DeleteMapping(path  = "/user",consumes = "application/json",produces = "String")
//	public String deleteUser(@RequestBody User user) {
//		boolean removed = userservice.remove(user);
//		if(removed) return "user " + user.getUsername() + " deleted.";
//		else return "Failed";
//	}
//	
	
	@DeleteMapping(path = "/user", consumes = "application/json", produces = "text/plain")
	public String deleteUser(@RequestBody User user) {
	    boolean removed = userservice.remove(user);
	    if (removed) return "user " + user.getUsername() + " deleted.";
	    else return "Failed";
	}

	@PutMapping("/user")
	public User putMName(@RequestBody User user) {
		//TODO: process PUT request
		return userservice.updateUser(user);
	}
	
//	@PatchMapping
//	public User patchUser(@RequestBody Map<String,String> map) {
//		User user = new User();
//		if(map.containsKey("enabled")) user.setEnabled(Boolean.valueOf(map.get("enabled")));
//		if(map.containsKey("password")) user.setEnabled(Boolean.valueOf(map.get("password")));
//		
//	}
//	



}


