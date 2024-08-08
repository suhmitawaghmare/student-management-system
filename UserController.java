package com.studentmanagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.model.User;
import com.studentmanagement.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/register")
	public String showRegister() {
		return "Register";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam Map<String, String>params,Model model) {
		String username=params.get("username");
		
		if(userservice.findByUsername(username)!=null) {
			model.addAttribute("error", "Username is already taken. Please choose another one.");
			return "redirect:/register?error=true";
		}
		
		User user=new User();
		user.setUsername(params.get("username"));
		user.setPassword(params.get("password"));
		userservice.saveUser(user);
		return "redirect:/login";
		
		

	}
}
