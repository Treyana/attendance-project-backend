package com.tumdy.attendance.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tumdy.attendance.domain.Student;


public interface StudentRepository extends CrudRepository<Student, Long>{
	
	Optional<Student> findByRollno(String rollno);

}
