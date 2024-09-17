package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	//	private Logger logger = LoggerFactory.getLogger(getClass()); //用log去檢查
	
	@Autowired
	private AuthenticationService authenticationService;
	

	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	@RequestMapping("login")
	public String loginPage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
//		logger.debug("Request param is {}", name);
//		logger.info("I want this print at info level");
//		logger.warn("I want this print at warn level");
//		System.out.println("Request param is "+ name); // Not Recommend for prod code
		return "login";
	}
	
	@RequestMapping(value = "login1", method = RequestMethod.GET)
	public String todologinPage() {
		return "login1";
	}
	
	@RequestMapping(value = "login1", method = RequestMethod.POST)
	public String todoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "Welcome";
		}
		model.put("errorMessage", "invalidCredentials! Please try again!");
		return "login1";
		
	}
	
}
