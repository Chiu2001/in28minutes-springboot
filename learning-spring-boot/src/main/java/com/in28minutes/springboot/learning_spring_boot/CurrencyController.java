package com.in28minutes.springboot.learning_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //REST controller是透過REST，以JSON格式與前端溝通
public class CurrencyController {
	
	@Autowired
	CurrencyServiceConfiguration currencyServiceConfiguration;
	@RequestMapping("/currency")
	public  CurrencyServiceConfiguration retrieveAllCourses(){
		return currencyServiceConfiguration;
	}
}
