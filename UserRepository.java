package com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.model.User;



public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);
}
