package com.boot.aop.service;

import org.springframework.stereotype.Service;

import com.boot.aop.model.User;

@Service
public class UserService {

	public User createUser(String userName) {

		User user = new User();
		user.setName(userName);

		return user;
	}

}
