package com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepo extends JpaRepository<Course, Long>{
	
	List<Course> findByAuthor(String Author);
	List<Course> findByName(String Name); //要跟欄位的名稱一樣
}
