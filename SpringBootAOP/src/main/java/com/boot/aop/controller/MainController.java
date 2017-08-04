package com.boot.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.aop.model.User;
import com.boot.aop.service.UserService;

@RestController
public class MainController {
	
	@Autowired
    private UserService userService;

    @RequestMapping("/user")
    public User user(String userName) {
        return userService.createUser(userName);
    }

}
