package com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.model.Trainer;



@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long>{

}
