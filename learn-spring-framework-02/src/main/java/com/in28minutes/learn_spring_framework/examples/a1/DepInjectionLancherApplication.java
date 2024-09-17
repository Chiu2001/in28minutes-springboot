package com.in28minutes.learn_spring_framework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.micrometer.observation.transport.Propagator.Setter;

@Component
class yourBusinessClass{
	//three types of dependency injection
	@Autowired // 1. field injection
	Dependency1 dependency1;
	@Autowired
	Dependency2 dependency2;
	
	public Dependency1 getDependency1() {
		return dependency1;
	}
	@Autowired //2. Setter Injection
	public void setDependency1(Dependency1 dependency1) {
		System.out.println("Setter Injection - Dependency1");
		this.dependency1 = dependency1;
	}
	
	public Dependency2 getDependency2() {
		return dependency2;
	}
	@Autowired
	public void setDependency2(Dependency2 dependency2) {
		System.out.println("Setter Injection - Dependency2");
		this.dependency2 = dependency2;
	}
	@Autowired // 3. Constructor 可以不用加@Autowired，大家較常使用
	public yourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - yourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "Using" + dependency1 + "and" + dependency2;
	}
}
@Component
class Dependency1{
	
}
@Component
class Dependency2{
	
}
@Configuration
@ComponentScan //組件掃描:掃描正確的包，找到組件(同一包裡不須加哪一個包)
public class DepInjectionLancherApplication {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(DepInjectionLancherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(yourBusinessClass.class));
		}
	}

}
