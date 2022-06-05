package com.webo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webo.demo.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	LoginService loginservice;
	@GetMapping("/")
	public String Welcome(ModelMap model)
	{
		//model.put("name",name);
		return "hellp";
	}
	@PostMapping("/login")
	public String ShowWelcome(ModelMap model, @RequestParam String name,@RequestParam String password)
	{	
		Boolean isvalid=loginservice.validate(name, password);
		if(isvalid) {
		model.put("name",name);
		return "Welcome";
	}
		else
		{
			return "hellp";
		}
}

}