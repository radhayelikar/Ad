package com.advertise.in.exception;

public class AdminNotFoundException extends RuntimeException {
	
	public AdminNotFoundException(String email) {
		
		super("Admin not found :"  + email);
		
	}
}

