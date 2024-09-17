package com.in28minutes.rest.webservices.restful_web_services.service;

import com.in28minutes.rest.webservices.restful_web_services.Dao.LoginDao;
import com.in28minutes.rest.webservices.restful_web_services.Dao.UserDao;
import com.in28minutes.rest.webservices.restful_web_services.res.LoginMessage;

public interface UserService {
    String addUser(UserDao userDao);
    LoginMessage loginUser(LoginDao loginDao);
}
