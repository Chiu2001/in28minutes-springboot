package com.in28minutes.learn_spring_framework.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service // 處理商務邏輯
public class BusinessCalculationService {
	private DataService dataService;
	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	public int findMax(){
		return Arrays.stream(dataService.retriveData()).max().orElse(0);
	}
}
