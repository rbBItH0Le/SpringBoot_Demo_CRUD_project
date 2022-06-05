package com.webo.demo.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
public Boolean validate(String username,String password)
{
	return username.equalsIgnoreCase("rohan") && password.equalsIgnoreCase("Pass");
}
}
