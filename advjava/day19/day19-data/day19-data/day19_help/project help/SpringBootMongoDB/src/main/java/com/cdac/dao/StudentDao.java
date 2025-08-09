package com.cdac.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cdac.model.Student;

public interface StudentDao extends MongoRepository<Student, String> {
	List<Student> findByAge(int age);
}
