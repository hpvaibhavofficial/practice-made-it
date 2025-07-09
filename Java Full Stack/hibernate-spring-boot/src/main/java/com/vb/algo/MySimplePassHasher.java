package com.vb.algo;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySimplePassHasher implements PasswordHasher{

	@Override
	public String hash(String password) {
		return password;
	}

	@Override
	public boolean match(String hash, String newPassword) {
		return hash.equals(newPassword);
	}

}