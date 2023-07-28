package com.sud.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sud.demo.model.Student;
import com.sud.demo.repo.StudentRepo;

@Service
public class StudentImpl implements StudentIfc {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void saveStudent(Student st) {
		studentRepo.save(st);
	}

	@Override
	public Student getStudentBasedonRollNo(int rollNo) {
		Optional<Student> st = studentRepo.findById(rollNo);
		return st.isPresent() ? st.get() : null;
	}

	@Override
	public String deleteStudentBasedOnRollNo(int rollNo) {
		Optional<Student> st = studentRepo.findById(rollNo);
		if(st.isPresent()) {
			studentRepo.delete(st.get());
			return "Record deleted success !!";
		}else {
			return "Record not found for RollNo : "+rollNo;
		}
	}

	@Override
	public List<Student> studentList() {
		List<Student> list = new ArrayList<>();
		studentRepo.findAll().forEach(st->list.add(st));
		return list;
	}
}
