package com.hcl.todo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.todo.model.User;
import com.hcl.todo.repo.UserRepository;


import jakarta.transaction.Transactional;

@Service

public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepository userrepo;
	
	@Override
	
	public User findByUsername(String username)
	{
		log.debug(" findBYUsername searching for {}",username);
		try
		{
	
		Optional<User> optional = userrepo.findById(username);
		return optional.orElse(null);
		}
		catch(Exception e) {
			log.error(username+" was not found");
			return null;
		}
	}
	
	@Override
	@Transactional
	public User addUser(User user) 
	{
		log.debug("trying to add user "+user.getUsername());
		userrepo.save(user);
		return user;
	}
}
