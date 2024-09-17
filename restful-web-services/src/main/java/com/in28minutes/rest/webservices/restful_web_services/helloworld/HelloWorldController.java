package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restful_web_services.Dao.LoginDao;
import com.in28minutes.rest.webservices.restful_web_services.Dao.UserDao;
import com.in28minutes.rest.webservices.restful_web_services.res.LoginMessage;
import com.in28minutes.rest.webservices.restful_web_services.entity.ConcertRepository;
import com.in28minutes.rest.webservices.restful_web_services.repository.Concert;
import com.in28minutes.rest.webservices.restful_web_services.service.UserService;


@RestController
@RequestMapping("api/v1")
public class HelloWorldController {

    @Autowired
    private ConcertRepository concertRepository;

    @GetMapping(path = "/concerts")
    public List<Concert> getConcerts() {
        return concertRepository.findAll();
    }
    
    @Autowired
    private UserService userService;
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDao userDao)
    {
        String id = userService.addUser(userDao);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDao loginDao)
    {
        LoginMessage loginResponse = userService.loginUser(loginDao);
        return ResponseEntity.ok(loginResponse);
    }
}
