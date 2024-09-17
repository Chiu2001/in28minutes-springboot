package com.in28minutes.learn_spring_framework.examples.a0;


import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.examples.a1") //組件掃描:掃描正確的包，找到組件
public class SimpleSpringContextLancherApplication {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(SimpleSpringContextLancherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}

}
