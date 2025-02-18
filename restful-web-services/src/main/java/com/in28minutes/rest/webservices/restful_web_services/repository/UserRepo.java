package com.in28minutes.rest.webservices.restful_web_services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restful_web_services.entity.User;



@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
      Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
