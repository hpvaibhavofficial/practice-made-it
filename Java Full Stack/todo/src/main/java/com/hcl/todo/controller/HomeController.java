package com.hcl.todo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.todo.model.Todo;
import com.hcl.todo.service.TodoService;
import com.hcl.todo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	@Autowired 
	TodoService todoService;
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String requestMethodName() {
		return "todohome"; // go to /WEB-INF/views/todohome.jsp
	}
	@PostMapping("/login")
	public String loginPage(@RequestParam("username") String username, 
			@RequestParam("password") String password, ModelMap map, 
			HttpServletRequest request)
	{	if(userService.checkLogin(username, password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("logintime",  new Date());
			session.setAttribute("ipaddress", request.getRemoteAddr());
			
			List<Todo> list = todoService.findAllByUsername(username);
			map.put("list",  list);
			map.put("username",  username);
			return "todos-view"; // go TO /WEB-INF/views/todos-view.jsp 
		}
		else
		{
			map.put("msg",  "Invalide username or password");
			return "todohome";
		}
	}
	
	@GetMapping("/mytodo")
	@ResponseBody
	public String getMyTodos()
	{
		return "list of todos";
	}
	@GetMapping("/register")
	public String register() {
		return "register.html";
	}

}


//package com.hcl.todo.controller;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//
//import com.hcl.todo.model.Todo;
//import com.hcl.todo.service.TodoService;
//import com.hcl.todo.service.UserService;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class HomeController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private TodoService todoService;
//
//    
//    @GetMapping("/")
//    public String showHomePage() {
//        return "todohome";  //we go to /webinf/views/todohome.jsp
//    }
//
//    // Handle login form submission
//    @PostMapping("/login")
//    public String loginPage(@RequestParam("username") String username,
//                            @RequestParam("password") String password,
//                            ModelMap map,HttpServletRequest request) {
//
//        if (userService.checkLogin(username, password)) {
//        	
//        	HttpSession session = request.getSession();
//        	session.setAttribute("useername ",username);
//        	session.setAttribute("loginTime ",new Date());
//        	session.setAttribute("ipadddress",request.getRemoteAddr());
//        	
//            List<Todo> list = todoService.findAllByUsername(username);
//            map.put("list", list); 
//            map.put("username", username);
//            return "todos-view";    // go to todo view /webinf,todos-view.jsp
//        }
//        else {
//        	map.put("error", "Invalid credentials!");
//        	map.put(username,"username");
//            return "todohome";
//            
//        }
//         
//    }
//}
