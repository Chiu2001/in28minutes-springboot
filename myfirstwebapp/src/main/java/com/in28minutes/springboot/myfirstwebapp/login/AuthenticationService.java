package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isInvalidUsername = username.equalsIgnoreCase("in28minutes");
		boolean isInvalidPassword = password.equalsIgnoreCase("in28minutes");
		
		return isInvalidUsername && isInvalidPassword;
	}
}
