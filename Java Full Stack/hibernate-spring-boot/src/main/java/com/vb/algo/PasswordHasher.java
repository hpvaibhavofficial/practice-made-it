package com.vb.algo;


//import org.springframework.stereotype.Component;
//
//@Component
//public class PasswordHasher {
//	public String encrypt(String password)
//	{
//		// write a program to return reverse of a string
//		StringBuilder sb = new StringBuilder(password);
//		StringBuilder reverse = sb.reverse();
//		return reverse.toString();
//	}
//
//}

public interface PasswordHasher{
	public String hash(String password);
	public boolean match(String hash,String newPassword);
}



