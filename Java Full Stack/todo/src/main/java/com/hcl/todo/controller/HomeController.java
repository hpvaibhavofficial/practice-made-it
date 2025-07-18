package com.hcl.todo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.hcl.todo.model.Todo;
import com.hcl.todo.service.TodoService;
import com.hcl.todo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    
    @GetMapping("/")
    public String showHomePage() {
        return "todohome";  //we go to /webinf/views/todohome.jsp
    }

    // Handle login form submission
    @PostMapping("/login")
    public String loginPage(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            ModelMap map,HttpServletRequest request) {

        if (userService.checkLogin(username, password)) {
        	
        	HttpSession session = request.getSession();
        	session.setAttribute("useername ",username);
        	session.setAttribute("loginTime ",new Date());
        	session.setAttribute("ipadddress",request.getRemoteAddr());
        	
            List<Todo> list = todoService.findAllByUsername(username);
            map.put("list", list); 
            map.put("username", username);
            return "todos-view";    // go to todo view /webinf,todos-view.jsp
        }
        else {
        	map.put("error", "Invalid credentials!");
        	map.put(username,"username");
            return "todohome";
            
        }
         
    }
}
