package com.example.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajpa.Repository.StudentRepository;
import com.example.springdatajpa.model.Student;

@SpringBootTest
class SpringdatajpaApplicationTests {
	@Autowired
	private StudentRepository repository;
	@Test
	void testSaveStudent() {
		Student student = new Student();
		student.setId(1l);
		student.setName("Vinay");
		student.setTestScore(100);
		repository.save(student);
		
		Student savedStudent = repository.findById(1l).get();
		assertNotNull(savedStudent);
	}
	
	@Test
	void testGetStudent() {
		Student student1 = repository.findById(1l).get();
		Student student = new Student();
		student.setId(1l);
		student.setName("Vinay");
		student.setTestScore(100);
		assertEquals(student1.getId(),student.getId());
		assertEquals(student1.getName(),student.getName());
		assertEquals(student1.getTestScore(),student.getTestScore());
		
	}
	
	@Test
	void testUpdateStudent() {
		Student student = new Student();
		student.setId(1l);
		student.setName("Vinay");
		student.setTestScore(100);
		repository.save(student);
		
		student.setName("Vinay1");
		repository.save(student);
		
		Student savedStudent = repository.findById(1l).get();
		assertEquals(savedStudent.getName(),student.getName());
	}
	
	@Test
	void testDeleteStudent()  throws Exception{
		Student student = new Student();
		student.setId(1l);
		student.setName("Vinay");
		student.setTestScore(100);
		repository.save(student);
		
		
		
		repository.delete(student);
		List<Student> student2= repository.findAll();
		List<Student> stu= Collections.EMPTY_LIST;
		assertEquals(stu,student2);
	}

}
