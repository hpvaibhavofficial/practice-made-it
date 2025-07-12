package com.lb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
