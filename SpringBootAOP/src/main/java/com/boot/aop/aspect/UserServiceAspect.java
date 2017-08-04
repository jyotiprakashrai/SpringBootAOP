package com.boot.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.boot.aop.model.User;



@Aspect
@Component
public class UserServiceAspect {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceAspect.class);

	    @Before("execution(* com.boot.aop.service.UserService.createUser (java.lang.String)) && args(userName)")
	    public void beforeSampleCreation(String userName) {

	        LOGGER.info("A request was issued for a user name: "+userName);
	    }

	    @Around("execution(* com.boot.aop.service.UserService.createUser (java.lang.String)) && args(userName)")
	    public Object aroundSampleCreation(ProceedingJoinPoint proceedingJoinPoint,String userName) throws Throwable {

	        LOGGER.info("A request was issued for a user name: "+userName);

	        userName = userName+"!";

	        User user = (User) proceedingJoinPoint.proceed(new Object[] {userName});
	        user.setName(user.getName().toUpperCase());

	        return user;
	    }

}
