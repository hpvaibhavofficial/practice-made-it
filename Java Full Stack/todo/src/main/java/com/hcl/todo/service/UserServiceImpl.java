package com.hcl.todo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.todo.model.User;
import com.hcl.todo.repo.ToDoRepository;
import com.hcl.todo.repo.UserRepository;


import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final ToDoRepository toDoRepository;
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepository userrepo;

    UserServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
	
	@Override
	@Transactional
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

	@Override
	public boolean checkLogin(String username, String password) {
		Optional<User> opt = userrepo.findById(username);
		if(opt.isPresent()) {
			String passIndB = opt.get().getPassword();
			if(passIndB.equals(passIndB)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public boolean remove(User user) {
		if(userrepo.findById(user.getUsername()) != null) {
			userrepo.deleteById(user.getUsername());
			return true;
		}
		return false;
	}

	@Override
	public User updateUser(User user) {
		if(userrepo.findById(user.getUsername()) != null) {
			//if user is transient then  it can throw an error
			userrepo.save(user);
			return user;
		}
		return null;
	}

	@Override
	public User patchUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

//	@ Override
//	public User patchUser(Map<String, String> map) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
