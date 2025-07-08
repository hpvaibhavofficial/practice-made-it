package com.vb.algo;

import org.springframework.stereotype.Component;

@Component
public class MynextPasswordHasher  implements PasswordHasher{

   
	@Override
	public String hash(String password) {
		StringBuilder sb  =  new StringBuilder(password);
		for(int i=0;i<password.length();i++) {
			char ch = (char) (password.charAt(i)+1);
			sb.setCharAt(i,ch);
		}
		return password;
	}

	@Override
	public boolean match(String hash, String newPassword) {
		StringBuilder sb  =  new StringBuilder(newPassword);
		for(int i=0;i<newPassword.length();i++) {
			char ch = (char) (newPassword.charAt(i)+1);
			sb.setCharAt(i,ch);
		}
		return sb.toString().equals(hash);
	}
	
}
