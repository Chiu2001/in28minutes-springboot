package com.in28minutes.learn_spring_framework.examples.d1;


import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
	
}

@Component
@Lazy
class ClassB{
	ClassA classA;
	public ClassB(ClassA classA) {
		System.out.println("Some Initialization logic");
		this.classA = classA;
	}
	public void doSomething() {
		System.out.println("Do Something");
	}
}
@Configuration
@ComponentScan //組件掃描:掃描正確的包，找到組件
public class LazyInitializationLancherApplication {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(LazyInitializationLancherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("Initialization of context is completed");
			context.getBean(ClassB.class).doSomething();
		}
	}

}
