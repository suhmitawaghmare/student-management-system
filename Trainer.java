package com.studentmanagement.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="trainer_table")
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long tid;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Mobile_No")
	private String mobile;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="Salary")
	private int salary;
	
	@OneToMany(mappedBy="trainer")
	List<Student> student;
	

	public String toString() {
		return String.valueOf(tid);
	}

}
	
	

