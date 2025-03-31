package com.manish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.manish.entity.Student;
import com.manish.service.StudentService;



@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		return ResponseEntity.ok("Welcome to the Student Management System");
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addNewStudent (@RequestBody Student student){
		try{
			Student savedStudent = studentService.addStudent(student);
			return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/addAllStudents")
	public ResponseEntity<List<Student>> addAllStudents(@RequestBody List<Student> students){
		try {
			List<Student> addStudents = studentService.addAllStudents(students);
			return new ResponseEntity<>(addStudents, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudents (){
		List<Student> studentList = studentService.getAllStudent();
			return ResponseEntity.ok(studentList);
	}
	
	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<Student>  getStudentById(@PathVariable ("id") int rollNo){
		Optional<Student> std = studentService.getStudentById(rollNo);
		if(std.isPresent()) {
			return ResponseEntity.ok(std.get());			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping("update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable ("id")  int rollNo, @RequestBody Student student){
		Optional<Student> std = studentService.getStudentById(rollNo);
		if(std.isPresent()) {
			Student updatedStudent = std.get();
			updatedStudent.setName(student.getName());
			updatedStudent.setSection(student.getSection());
			updatedStudent.setClassName(student.getClassName());
			studentService.addStudent(updatedStudent);
			return ResponseEntity.ok(updatedStudent);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/deleteStudentById/{id}")
	public ResponseEntity<String> deteleStudentRecord(@PathVariable ("id") int rollNo){
		Optional<Student> std = studentService.getStudentById(rollNo);
		if(std.isPresent()) {
			studentService.deleteStudentById(rollNo);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student has been deleted");			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found..");
		}
	}
}