package com.vb.algo;

public interface PasswordHasher {
	String hash(String password);
	boolean match(String hash, String newPassword);

}


