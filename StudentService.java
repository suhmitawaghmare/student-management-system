package com.studentmanagement.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studrepo;

	public List<Student> getAllStudents()
	{
		return studrepo.findAll();
	}
	
	public Student getStudentById(Long id) {
		return studrepo.findById(id).orElse(null);
	}
	
	public void saveStudent(Student stu) {
		studrepo.save(stu);
	}
	
	public void deleteStudById(Long id) {
		studrepo.deleteById(id);
	}
}
