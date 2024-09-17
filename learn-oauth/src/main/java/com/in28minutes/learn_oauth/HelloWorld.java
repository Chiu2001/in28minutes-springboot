package com.in28minutes.learn_oauth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@GetMapping("/")
	public String Hello(Authentication authentication){
		System.out.println(authentication);
		return "helloWorld";
	}
}
