package com.manish.service;

import java.util.List;
import java.util.Optional;

import com.manish.entity.Student;

public interface StudentService {
	
	Student addStudent (Student student); 
	
	List<Student> addAllStudents(List<Student> students);
	
	List<Student> getAllStudent();
	
	Optional<Student> getStudentById (int rollNo);
	
	Student updateStudentById(Student student);
	
	void deleteStudentById (int id);

}
