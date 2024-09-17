package com.in28minutes.rest.webservices.restful_web_services.Impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restful_web_services.Dao.LoginDao;
import com.in28minutes.rest.webservices.restful_web_services.Dao.UserDao;
import com.in28minutes.rest.webservices.restful_web_services.entity.User;
import com.in28minutes.rest.webservices.restful_web_services.repository.UserRepo;
import com.in28minutes.rest.webservices.restful_web_services.res.LoginMessage;
import com.in28minutes.rest.webservices.restful_web_services.service.UserService;



@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDao userDao) {
        User user = new User(
        		userDao.getUserid(),
                userDao.getUsername(),
                userDao.getEmail(),
               this.passwordEncoder.encode(userDao.getPassword()),
               userDao.getGender(),
               userDao.getBirthday(),
               userDao.getTel(),
               userDao.getAddress()
                
        );
        userRepo.save(user);
        return user.getUsername();
    }
    UserDao userDao;
    @Override
    public LoginMessage  loginUser(LoginDao loginDao) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDao.getEmail());
        if (user1 != null) {
            String password = loginDao.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDao.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }
    }
}