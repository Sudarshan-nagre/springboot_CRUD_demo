package com.sud.demo.service;

import java.util.List;

import com.sud.demo.model.Student;

public interface StudentIfc {

	public void saveStudent(Student st);
	
	public Student getStudentBasedonRollNo(int rollNo);
	
	public String deleteStudentBasedOnRollNo(int rollNo);

	public List<Student> studentList();
}
