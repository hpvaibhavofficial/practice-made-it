package com.vb.algo;

import org.springframework.stereotype.Component;

@Component
public class MynextPasswordHasher implements PasswordHasher{

	@Override
	public String hash(String password) {
		// WRITE A PROGRAM TO RETURN NEXT FOR EACH CHARACTER AND CREATE A NEW STRING
		StringBuilder sb = new StringBuilder(password);
		for(int i = 0; i<password.length(); i++)
		{
			char ch = (char) (password.charAt(i) + 1);
			sb.setCharAt(i, ch);
		}
		return sb.toString();
	}

	@Override
	public boolean match(String hash, String newPassword) {
		//WRITE AN ALGORITHM TO MATCH THE PASSWORD WITH HASH GENERATED ABOVE
		StringBuilder sb = new StringBuilder(newPassword);
		for(int i = 0; i<newPassword.length(); i++)
		{
			char ch = (char) (newPassword.charAt(i)  + 1);
			sb.setCharAt(i, ch);
		}
		return sb.toString().equals(hash);
	}

}