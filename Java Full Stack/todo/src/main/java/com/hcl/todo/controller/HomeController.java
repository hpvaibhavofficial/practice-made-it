package com.hcl.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
//when i will have req of n=home page 
public class HomeController {
	
	@GetMapping("/")
	public String requestMethodName() {
		return  "todohome";
	}
	//when furst req qill 
}
