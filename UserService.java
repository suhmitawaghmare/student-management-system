package com.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.model.User;
import com.studentmanagement.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userrepo;
	
	public void saveUser(User user) {
		userrepo.save(user);
	}
	
	public User findByUsername(String username) {
		return userrepo.findByUsername(username);
	}


		
		
	}

