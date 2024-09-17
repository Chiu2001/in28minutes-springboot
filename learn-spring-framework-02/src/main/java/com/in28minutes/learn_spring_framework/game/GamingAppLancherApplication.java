package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game") //組件掃描:掃描正確的包，找到組件
public class GamingAppLancherApplication {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(GamingAppLancherApplication.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}

}
