package com.vb.algo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

//scope tells when any how the spring will create new instances of bean
//@Scope(value = "singleton") //default 
//@Scope(value = "prototype") // create new object everytime asked for
//@Scope("request") // will create new object for every request
//@Scope("session") // for user session create new object 
//@Scope("application") //
//@Scope("")

public class MyService {
	
	@Autowired
	public MyService(PasswordHasher hasher1, PasswordHasher hasher2) {
		mynextPasswordHasher = hasher1;
		paswordHasher = hasher2;
	}
	
	public MyService(){
		
	}
	
	public PasswordHasher getMynextPasswordHasher() {
		return mynextPasswordHasher;
	}

	@Autowired
	public void setMynextPasswordHasher(PasswordHasher mynextPasswordHasher) {
		this.mynextPasswordHasher = mynextPasswordHasher;
	}

	public PasswordHasher getPaswordHasher() {
		return paswordHasher;
	}

	@Autowired
	public void setPaswordHasher(PasswordHasher paswordHasher) {
		this.paswordHasher = paswordHasher;
	}

	//	@Autowired
	PasswordHasher mynextPasswordHasher;
	
	// @Autowired
	PasswordHasher paswordHasher;

	public void show() {
		System.out.println("hashers are  = "+ mynextPasswordHasher +" and "+paswordHasher);
	}
}
