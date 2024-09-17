package com.in28minutes.springboot.learning_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //REST controller是透過REST，以JSON格式與前端溝通
public class CourseController {
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1, "Learn AWS", "in 28mins"),
				new Course(2, "Learn DevOps", "in 28mins"),
				new Course(3, "Learn Azure", "in 28mins")
				);
	}
}
