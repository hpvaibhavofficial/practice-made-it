package com.vb.lib.service;

import com.vb.model.Student;

import jakarta.transaction.Transactional;

public interface StudentService {

	Student add(Student student);
	Student findById(int roll);

}