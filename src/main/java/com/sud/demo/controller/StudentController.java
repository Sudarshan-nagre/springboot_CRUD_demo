package com.sud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sud.demo.model.Student;
import com.sud.demo.service.StudentIfc;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentIfc studentIfc;

	@GetMapping
	public ResponseEntity<String> showMsg() {
		return new ResponseEntity<String>("Testing Rest API", HttpStatus.OK);
	}
	
	@GetMapping("/{rollNo}")
	public ResponseEntity<Student> getStudentBasedOnRollNo(@PathVariable("rollNo") int rollNo) {
		return new ResponseEntity<Student>(studentIfc.getStudentBasedonRollNo(rollNo), HttpStatus.OK);
	}
	
	@DeleteMapping("/{rollNo}")
	public ResponseEntity<String> deleteStudentBasedOnRollNo(@PathVariable("rollNo") int rollNo) {
		return new ResponseEntity<String>(studentIfc.deleteStudentBasedOnRollNo(rollNo), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student st) {
		studentIfc.saveStudent(st);
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Student>> studentList() {
		return new ResponseEntity<List<Student>>(studentIfc.studentList(), HttpStatus.OK);
	}
}
