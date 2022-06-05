package com.webo.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webo.demo.model.Todo;
import com.webo.demo.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
@Autowired
TodoService service;
@RequestMapping("/todo-list")
public String showTodo(ModelMap model)
{
	//model.put("name",name);
	String name=(String) model.get("name");
	System.out.println(name);
	model.put("todos",service.retrieveTodos("in28Minutes")); 
	return "todohome";
}
@RequestMapping("/addto")
public String Addto(ModelMap model)
{
	//model.put("name",name);
	String name=(String) model.get("name");
	System.out.println(name);
	model.put("todos",service.retrieveTodos("in28Minutes")); 
	return "addto";
}
@PostMapping("/addto")
public String Savn(ModelMap model,@RequestParam String desc)
{
	String name=(String) model.get("name");
	service.addTodo("in28Minutes", desc, new Date(), false);
	return "redirect:/todo-list";
}
@RequestMapping("/deletetodo")
public String Deletetodo(@RequestParam int id)
{
	service.deleteTodo(id);
	return "redirect:/todo-list";
}
@RequestMapping("/updatetodo")
public String Updatetodo(@RequestParam int id,ModelMap model)
{
	Todo todo=service.retrieveTodo(id);
	service.updateTodo(todo);
	return "redirect:/todo-list";
}

private String getLoggedInUsername()
{
	Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	if(principal instanceof UserDetails)
	{
		return ((UserDetails)principal).getUsername();
	}
	return principal.toString();
	}
}
}
