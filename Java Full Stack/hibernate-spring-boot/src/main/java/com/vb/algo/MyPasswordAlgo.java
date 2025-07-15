package com.vb.algo;


import org.springframework.stereotype.Component;
// spring will create an object of this class (JUST ONE )
@Component
public class MyPasswordAlgo {
	public String encrypt(String password)
	{
		// write a program to return reverse of a string
		StringBuilder sb = new StringBuilder(password);
		StringBuilder reverse = sb.reverse();
		return reverse.toString();
	}

}