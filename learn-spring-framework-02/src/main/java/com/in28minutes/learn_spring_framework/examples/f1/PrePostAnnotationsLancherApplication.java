package com.in28minutes.learn_spring_framework.examples.f1;


import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency dependency;

	public SomeClass(SomeDependency dependency) {
		super();
		this.dependency = dependency;
		System.out.println("All dependecies are ready");
	}
	@PostConstruct //
	public void initialize() {
		SomeDependency.getReady();
	}
	@PreDestroy
	public void cleanup() {
		System.out.println("Cleanup");
	}
	
}

@Component 
class SomeDependency{

	public static void getReady() {
		System.out.println("Some logic using dependency");
		
	}
	
}
@Configuration
@ComponentScan //組件掃描:掃描正確的包，找到組件
public class PrePostAnnotationsLancherApplication {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsLancherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}

}
