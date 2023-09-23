package com.tumdy.attendance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tumdy.attendance.domain.Student;
import com.tumdy.attendance.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	private final StudentService studentService;
	
	@GetMapping("/all")
	public List<Student> getAllStudent(){
		return studentService.findAll();
	}
	
	@PostMapping("/create/{classId}")
	public ResponseEntity<?> createStudent(@RequestBody Student student,@PathVariable Long classId){
		
		Student savedStudent = studentService.createStudent(student, classId);
		
		return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED);
	}
	
	@PatchMapping("/update/{classId}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable Long classId){
		Student updatedStudent = studentService.updateStudent(student, classId);
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		studentService.deleteByStudentId(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Student> studentOptional = studentService.findByStudentId(id);
		
		if(studentOptional.isEmpty())
			return new ResponseEntity<String>("Delete id"+id,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Student>(studentOptional.get(),HttpStatus.OK);
	}
	

}
