package com.hcl.todo.controller;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.todo.model.User;
import com.hcl.todo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


//@Controller
// all methods of this class will return the object (JSON) ACTUAL RESPONSE AND NOT VIEW NAME

@RestController 
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500", "*"} ,
methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	@GetMapping(path="/user/{username}", produces="application/json")
	public User getUserByname(@PathVariable ("username") String username)
	{
		log.debug("request for user {}", username);
		return userService.findByUsername(username); //returns actual data
	}
	
	@GetMapping(path="/user", produces="application/json")
	public User getUser(@RequestParam("username") String username, HttpServletRequest request)
	{
		return userService.findByUsername(username); //returns name of view 
	}
	@GetMapping("/qualification" )
	
	public String saveQualification(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpSession session, 
			@SessionAttribute String username)
	{
		request.getSession().getAttribute("username");
		
		log.debug("{}", map);
		return "qualification saved";
	}
	
	
	
	
	@GetMapping(path="/users", produces="application/json")
	public List<User> findAll()
	{
		return userService.findAll();
	}
	@PostMapping(path="/user", consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User user) {
		User added = userService.addUser(user);
		return added;
	}
	@DeleteMapping(path="/user", consumes = "application/json", produces = "application/json")
	public String deleteUser(@RequestBody User user) {
		boolean removed = userService.remove(user);
		if(removed) return "User " + user.getUsername() + " deleted ";
		else return "FAILED Deleting " + user.getUsername();
	}
	@PutMapping(path = "/user", consumes = "application/json", produces = "application/json")
	public User putMethodName(@RequestBody User user) {
		return userService.updateUser(user);
	}
	@PatchMapping(path="/user", consumes = "application/json", produces = "application/json")
	public User patchUser(@RequestBody Map<String, String> map)
	{
		User patched = userService.patchUser(map);
		return patched;
	}
	
	
	
	@Autowired
	JdbcUserDetailsManager userManager;
	@Autowired
	PasswordEncoder passEncoder;
	
	@PostMapping("/user-create")
	public String postMethodName(@RequestBody Map<String,String> map) {
		//TODO: process POST requestUser(String username, String password, boolean enabled, boolean accountNonExpired,
//		boolean credentialsNonExpired, boolean accountNonLocked,
//		Collection<? extends GrantedAuthority> authorities) 
		log.debug("{}", map);
		String username = map.get("username");
		String password = passEncoder.encode(map.get("password"));
		List<SimpleGrantedAuthority> list = List.of(new SimpleGrantedAuthority("ROLE_USER"));
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, password, true, true, true, true,list);
		userManager.createUser(user);
		ObjectMapper mapper = new ObjectMapper();
		String stringJson = "{ message : \"not created\" }";
		try {
			stringJson = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return stringJson;
	}
	@GetMapping("/current-user")
	public String getMethodName(Authentication auth) {
		if(auth != null && auth.isAuthenticated())
		{
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
			return user.getUsername();
		}
		return "NO User";
	}
	

}
//
//import java.util.Enumeration;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.SessionAttribute;
//
//import com.hcl.todo.model.User;
//import com.hcl.todo.service.UserService;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//
//
////@Controller
//// all methods of this class will return the object (JSON) ACTUAL RESPONSE AND NOT VIEW NAME
//
//@RestController 
//@RequestMapping("/api")
//public class UserController {
//	private static final Logger log = LoggerFactory.getLogger(UserController.class);
//	@Autowired
//	UserService userService;
//	@GetMapping(path="/user/{username}", produces="application/json")
//	public User getUserByname(@PathVariable ("username") String username)
//	{
//		log.debug("request for user {}", username);
//		return userService.findByUsername(username); //returns actual data
//	}
//	
//	@GetMapping(path="/user", produces="application/json")
//	public User getUser(@RequestParam("username") String username, HttpServletRequest request)
//	{
//		Enumeration<String> headerNames = request.getHeaderNames();
//		while(headerNames.hasMoreElements())
//		{
//			String headerName = headerNames.nextElement();
//			String headerValue = request.getHeader(headerName);
//			System.out.println(headerName + ": " + headerValue);
//		}
//		return userService.findByUsername(username); //returns name of view 
//	}
//	@GetMapping("/qualification" )
//	
//	public String saveQualification(@RequestParam Map<String, String> map,
//			HttpServletRequest request, HttpSession session, 
//			@SessionAttribute String username)
//	{
//		request.getSession().getAttribute("username");
//		
//		log.debug("{}", map);
//		return "qualification saved";
//	}
//	
//	
//	
//	
//	@GetMapping(path="/users", produces="application/json")
//	public List<User> findAll()
//	{
//		return userService.findAll();
//	}
//	@PostMapping(path="/user", consumes = "application/json", produces = "application/json")
//	public User addUser(@RequestBody User user) {
//		User added = userService.addUser(user);
//		return added;
//	}
//	@DeleteMapping(path="/user", consumes = "application/json", produces = "application/json")
//	public String deleteUser(@RequestBody User user) {
//		boolean removed = userService.remove(user);
//		if(removed) return "User " + user.getUsername() + " deleted ";
//		else return "FAILED Deleting " + user.getUsername();
//	}
//	@PutMapping(path = "/user", consumes = "application/json", produces = "application/json")
//	public User putMethodName(@RequestBody User user) {
//		return userService.updateUser(user);
//	}
//	@PatchMapping(path="/user", consumes = "application/json", produces = "application/json")
//	public User patchUser(@RequestBody Map<String, String> map)
//	{
//		User patched = userService.patchUser(map);
//		return patched;
//	}
//	
//	
//
//}
//import java.util.Enumeration;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import com.hcl.todo.TodoApplication;
//import com.hcl.todo.model.User;
//import com.hcl.todo.service.UserService;
//
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//@RestController //all methods of this class will return the object in the form of json
////@Controller
//
//@RequestMapping("/api")
//public class UserController {
//
//    private final TodoApplication todoApplication;
//	
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
//
//	@Autowired
//	UserService userservice;
//
//    UserController(TodoApplication todoApplication) {
//        this.todoApplication = todoApplication;
//    }
//	
//	@GetMapping(path = "/user/{username}",produces = "application/json")
//	public User getUserByName(@RequestParam("username")String username) {
//		log.debug("Request for user {}",username);
//		return userservice.findByUsername(username); //return the actua; data 
//		
//	}
//	
//	@GetMapping(path = "/user",produces = "application/json")
//	//@ResponseBody
//	public User getUser(@RequestParam("username")String username,HttpServletRequest request) {
//		Enumeration<String> headerNames = request.getHeaderNames();//an interface lijke list is otdated now
//		
//		while(headerNames.hasMoreElements()) {
//			String hn = headerNames.nextElement();
//			String hv = request.getHeader(hn) ;
//			System.out.println(hn + ":" + hv);
//		}
//		return userservice.findByUsername(username); // we have written @controoller and controller return name of view
//		
//	}
//	
//	@GetMapping("/qualification")
//	public String saveQualification(@RequestParam Map<String,String> map) {
//		log.debug("{}",map);
//		return "qualification saved";
//	}
//	
//	@GetMapping("/users")
//	public List<User> findAll()
//	{
//		return userservice.findAll();
//	}
//	
//	@PostMapping(path  = "/user",consumes = "application/json",produces = "application/json")
//	public User addUser(@RequestBody User user) {
//		User added = userservice.addUser(user);
//		
//		return added;
//	}
//	
////	@DeleteMapping(path  = "/user",consumes = "application/json",produces = "String")
////	public String deleteUser(@RequestBody User user) {
////		boolean removed = userservice.remove(user);
////		if(removed) return "user " + user.getUsername() + " deleted.";
////		else return "Failed";
////	}
////	
//	
//	@DeleteMapping(path = "/user", consumes = "application/json", produces = "text/plain")
//	public String deleteUser(@RequestBody User user) {
//	    boolean removed = userservice.remove(user);
//	    if (removed) return "user " + user.getUsername() + " deleted.";
//	    else return "Failed";
//	}
//
//	@PutMapping("/user")
//	public User putMName(@RequestBody User user) {
//		//TODO: process PUT request
//		return userservice.updateUser(user);
//	}
//	
////	@PatchMapping
////	public User patchUser(@RequestBody Map<String,String> map) {
////		User user = new User();
////		if(map.containsKey("enabled")) user.setEnabled(Boolean.valueOf(map.get("enabled")));
////		if(map.containsKey("password")) user.setEnabled(Boolean.valueOf(map.get("password")));
////		
////	}
////	
//
//
//
//}
//
//
