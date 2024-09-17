package com.in28minutes.learn_spring_framework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 1.Launch a Spring Context -
		try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			System.out.println(context.getBean("name")); // getBean()裡放method的名稱
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));
			System.out.println(context.getBean("person5Qualifier"));
			System.out.println(context.getBean("address2")); // use name
			System.out.println(context.getBean(Address.class)); // use type，but Address must be a only Object
			// 2.Configure the things that we want spring to manage -
			// HelloWorldConfiguration -@Configuration
			// name -@Bean
			System.out.println(context.getBean(Person.class));
			// print all beans
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); // list all spring beans managed by Spring Framework
		}
		;

	}

}
