package com.manish.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.entity.Student;
import com.manish.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	
	@Autowired
	private StudentRepository repository;


	public Student addStudent(Student student) {
		return repository.save(student);
	}


	public List<Student> getAllStudent() {
		return repository.findAll();
	}


	public Optional<Student> getStudentById(int rollNo) {
		return Optional.of(repository.findById(rollNo).get());
	}


	public Student updateStudentById(Student student) {
		return repository.save(student);
	}

	@Override
	public void deleteStudentById(int id) {
		repository.deleteById(id);
		
	}


	@Override
	public List<Student> addAllStudents(List<Student> students) {
		return repository.saveAll(students);
	}
	
}
