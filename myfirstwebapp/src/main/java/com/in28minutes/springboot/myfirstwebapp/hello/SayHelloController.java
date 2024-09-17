package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //處理Web請求的annotation
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String SayHello() {
		return "Hello! What are you learning today?";
	}
	
	// myfirstwebapp/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String SayHelloJsp() {
		return "sayHello";
	}
}
