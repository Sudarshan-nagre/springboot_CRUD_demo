package com.sud.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sud.demo.model.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{

}
