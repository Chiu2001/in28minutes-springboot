package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJDBCRepo;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepo;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepo;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
//	@Autowired 
//	private CourseJDBCRepo repo;
	
//	@Autowired 
//	private CourseJpaRepo repo;
	
	@Autowired 
	private CourseSpringDataJpaRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Course(1, "Learn AWS Now!", "in28minutes"));
		repo.save(new Course(2, "Learn Azure Now!", "in28minutes"));
		repo.save(new Course(3, "Learn Dev Now!", "in28minutes"));
		repo.deleteById((long) 1);
		System.out.println(repo.findById((long) 2));
		System.out.println(repo.findById((long) 3));
		
		System.out.println(repo.findAll());
		System.out.println(repo.count());
		System.out.println(repo.findByAuthor("in28minutes"));
		System.out.println(repo.findByName("Learn Dev Now!"));
	}
	
}
