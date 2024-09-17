package com.in28minutes.learn_spring_framework.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository //處理資料庫
@Primary
public class MongoDbDataService implements DataService{

	@Override
	public int[] retriveData() {
		return new int[] {11, 22, 33, 44, 55};
	}

}
