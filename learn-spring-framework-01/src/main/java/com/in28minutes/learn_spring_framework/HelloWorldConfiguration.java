package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {}
record Address(String area, String city) {}
@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "David";
	}
	@Bean
	public int age() {
		return 23;
	}
	@Bean 
	public Person person() {
		var person = new Person("Amy", 21);
		return person;
	}
	
	@Bean 
	public Address address() {
		var address = new Address("Luadong", "Yilan");
		return address;
	}

}
