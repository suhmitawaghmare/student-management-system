package com.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagement.model.Trainer;
import com.studentmanagement.service.TrainerService;


@Controller
public class TrainerController {

	@Autowired
	private TrainerService trainServ;
	
//	@GetMapping("/welcome")
//	public String welcomePage() {
//		return "Welcome";
//	}
	
//	@GetMapping("/trindex")
//	public String listTrainers(Model model) {
//		
//		model.addAttribute("listTrainer", trainServ.getAllTrainers());
//		return "trainer_index";
//
//	}

	
	@GetMapping("/viewTrainer2")
	public String viewTrainer(Model model) {
		
		model.addAttribute("listTrainer", trainServ.getAllTrainers());
		return "Trainer_Data2";
	}
	
	@GetMapping("/newTrainerForm")
	public String newTrainer(Model model) {
		
		Trainer tr=new Trainer();
		model.addAttribute("trainer", tr);
		return "New_trainer";
	}
	
	@PostMapping("/saveTr")
	public String saveTrainer(@ModelAttribute("trainer") Trainer tr) {
		trainServ.saveTrainer(tr);
		return "redirect:/trindex";
	}
	
	@GetMapping("/updateTr/{id}")
	public String updateTrainer(@PathVariable(value="id") Long id,Model model) {
		
		Trainer tr=trainServ.getTrainerById(id);
		model.addAttribute("trainer",tr);
		return "update_Trainer";
	}
	
	@GetMapping("/deleteTr/{id}")
	public String deleteTrainer(@PathVariable(value="id")Long id) {
		this.trainServ.deleteTrainerById(id);
		return "redirect:/trindex";
	}
}
