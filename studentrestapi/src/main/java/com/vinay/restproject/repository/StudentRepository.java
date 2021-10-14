package com.vinay.restproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.restproject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
