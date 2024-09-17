package com.in28minutes.learn_spring_framework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

// CDI(Jakarta Context & Dependency Injection) 寫法 Spring framework impelments CDI
// @Component -> @Named @Autowired -> @Inject
//@Component
@Named
class BusinessService {
	DataService dataservice;

	//@Autowired
	@Inject
	public void setDataservice(DataService dataservice) {
		System.out.println("Setter Injection");
		this.dataservice = dataservice;
	}

	public DataService getDataservice() {
		return dataservice;
	}

}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class SimpleSpringContextLancherApplication {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(SimpleSpringContextLancherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(BusinessService.class).getDataservice());
		}
	}

}
