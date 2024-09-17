package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {}
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
		var person = new Person("Amy", 21, new Address("101", "Taipei"));
		return person;
	}
	@Bean 
	public Person person2MethodCall() {
		return new Person(name(),age(),address()); // record Person(String name, int age)use name(), age()
	}
	@Bean 
	public Person person3Parameters(String name,int age, Address address3) {
		return new Person(name,age,address3); // record Person(String name, int age)use parameters
	}
	@Bean 
	@Primary
	public Person person4Parameters(String name,int age, Address address) {
		return new Person(name,age,address); // use address function
	}
	@Bean 
	public Person person5Qualifier(String name,int age, @Qualifier("address3qualifier") Address address) {
		return new Person(name,age,address); // use qualifier
	}
	@Bean (name = "address2") // name = your custom name
	@Primary // add primary
	public Address address() {
		var address = new Address("Luadong", "Yilan");
		return address;
	}
	@Bean (name = "address3") // name = your custom name
	@Qualifier("address3qualifier")
	public Address address3() {
		var address = new Address("Tamkong", "New Taipei");
		return address;
	}

}
