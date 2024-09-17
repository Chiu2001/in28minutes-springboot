package com.in28minutes.learn_spring_framework.examples.e1;


import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //one per Spring IOC Container
class NomalClass {
	
}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //Possibly many per Spring IOC Container
@Component
class PrototypeClass {
	
}
@Configuration
@ComponentScan //組件掃描:掃描正確的包，找到組件
public class BeanScopesLancherApplication {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(BeanScopesLancherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(NomalClass.class));
			System.out.println(context.getBean(NomalClass.class));
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
		}
	}

}
