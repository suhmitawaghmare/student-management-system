package com.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.model.Trainer;
import com.studentmanagement.repository.TrainerRepository;


@Service
public class TrainerService {

	@Autowired
	private TrainerRepository trainrepo;
	
	public List<Trainer> getAllTrainers(){
		return trainrepo.findAll();
	}
	
	public Trainer getTrainerById(Long id) {
		return trainrepo.findById(id).orElse(null);
	}
	
	public void saveTrainer(Trainer tr) {
		trainrepo.save(tr);
	}
	
	public void deleteTrainerById(Long id) {
		trainrepo.deleteById(id);
	}
}
