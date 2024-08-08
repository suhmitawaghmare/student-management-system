package com.studentmanagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.model.User;
import com.studentmanagement.service.StudentService;
import com.studentmanagement.service.TrainerService;
import com.studentmanagement.service.UserService;


@Controller
public class AdminController {

	@Autowired
	private StudentService studserv;
	
	@Autowired
	private TrainerService trainServ;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String listStudents(Model model) {
		return "index";
	}
	
	@GetMapping("/trindex")
	public String listTrainers(Model model) {
		return "trainer_index";

	}
	
	
	@GetMapping("/login")
	public String loginPage(@RequestParam(value="error",required=false)String error,Model model) {
		if(error!=null) {
			model.addAttribute("error", "Invalid credentials, please try again.");
		}
		return "login";
	}
	
	
//	@GetMapping("/loginDetails")
//	public String login(@RequestParam("username") String username,@RequestParam("password") String password) {
//		if("admin".equals(username) && "admin".equals(password)) {
//			return "redirect:/welcome";
//		}else {
//			return "redirect:/welcome2";
//		}
//	}
	
	@GetMapping("/loginDetails")
	public String login(@RequestParam Map<String,String>params) {
		String username=params.get("username");
		String password=params.get("password");
		
		User user=userservice.findByUsername(username);
		
		if("admin".equals(username) && "admin".equals(password)) {
			return "redirect:/welcome";
		}
		
		else if(user!=null && user.getPassword().equals(password)) {
			return "redirect:/welcome2";
		}
		else {
			return "redirect:/login?error=true";
		}
		
		
	}
	
	@GetMapping("/welcome")
	public String welcomePage() {
		return "Welcome";
	}
	
	@GetMapping("/viewTrainer")
	public String viewTrainer(Model model) {
		
		model.addAttribute("listTrainer", trainServ.getAllTrainers());
		return "Trainer_data_A";
	}
	@GetMapping("/viewStudent")
	public String viewStudent(Model model) {
		model.addAttribute("listStudent", studserv.getAllStudents());

		return "Student_data_A";
	}


	
	
	
	
}
