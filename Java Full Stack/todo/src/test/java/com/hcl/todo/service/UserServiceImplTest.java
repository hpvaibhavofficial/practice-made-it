package com.hcl.todo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.todo.model.User;
@SpringBootTest
class UserServiceImplTest {
	
	public static List<String> list = new ArrayList();
	@Autowired
	UserService userservice;

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

	@Test
	void testFindByUsername() {
		User byusername = userservice.findByUsername("yash");
		assertNotNull(byusername);
		
	}
	
	@Test
	void testFindByUsernameNotxist() {
		User byusername = userservice.findByUsername("not existing user");
		assertNull(byusername);
		
	}
	
//	@Test
//	void testFindByUsernameNull() {
//		User byusername = userservice.findByUsername(null);
//		assertNull(byusername);
//		
//	}

	@Test
	void testAddUser() {
		//ount of xisting users firstly we need to check this then we have to add other user and w have to check 
		//whether count is incremented
		//delete the dummy user added
		String username = "Glen"+System.currentTimeMillis();
		User user = new User("Glen","maxi",true);
		userservice.addUser(user);
		list.add(username);
	}
	
	

}
