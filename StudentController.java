package com.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;
import com.studentmanagement.service.TrainerService;


@Controller
public class StudentController {

	@Autowired
	private StudentService studserv;
	
	@Autowired
	private TrainerService trainers;
	
//	@GetMapping("/")
//	public String listStudents(Model model) {
//		model.addAttribute("listStudent", studserv.getAllStudents());
//		return "index";
//	}
	
	
	@GetMapping("/welcome2")
	public String welcomePage() {
		return "Welcome2";
	}
	@GetMapping("/viewStudent2")
	public String viewStudent(Model model) {
		model.addAttribute("listStudent", studserv.getAllStudents());
		return "student_data_S";
	}
	
	
	@GetMapping("/newStudentForm")
	public String newStudent(Model model) {
		
		Student stud=new Student();
		model.addAttribute("student",stud);
		model.addAttribute("trainers",trainers.getAllTrainers());
		return "New_student";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student stud) {
		
		studserv.saveStudent(stud);
		return "redirect:/";
		
	}
	
	@GetMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable(value="id") Long id, Model model) {
		
		Student stud=studserv.getStudentById(id);
		model.addAttribute("student",stud);
		model.addAttribute("trainers",trainers.getAllTrainers());
		return "Update_Student";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value="id") Long id) {
		this.studserv.deleteStudById(id);
		return "redirect:/";
	}
}
