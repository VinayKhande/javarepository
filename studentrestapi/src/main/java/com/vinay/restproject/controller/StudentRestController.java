package com.vinay.restproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.restproject.model.Student;
import com.vinay.restproject.repository.StudentRepository;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentRepository repo;
	
	@RequestMapping(value="/students/",method=RequestMethod.GET)
	public List<Student> getStudents() {
		return repo.findAll();
	}
	
	@RequestMapping(value="/students/{id}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable("id") int id) {
		return repo.findById(id).get();
	}
	
	@RequestMapping(value="/students/",method=RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		return repo.save(student);
	}
	
	@RequestMapping(value="/stuents/",method=RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		return repo.save(student);
	}
	
	@RequestMapping(value="/students/{id}",method=RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") int id) {
		repo.deleteById(id);
	}

}
