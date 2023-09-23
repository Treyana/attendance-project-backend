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

import com.tumdy.attendance.domain.Subject;
import com.tumdy.attendance.service.SubjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subject")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
	
	private final SubjectService subjectService;
	
	@GetMapping("/all")
	public List<Subject> getAllSubject(){
		return subjectService.findAll();
	}
	
	@PostMapping("/create/{userId}/{classId}/{semesterId}")
	public ResponseEntity<?> createSubject(@RequestBody Subject subject,@PathVariable Long userId,@PathVariable Long classId,@PathVariable Long semesterId){
		
		Subject savedSubject = subjectService.createSubject(subject,userId,classId,semesterId);
		
		return new ResponseEntity<Subject>(savedSubject,HttpStatus.CREATED);
	}
	
	@PatchMapping("/update/{userId}/{classId}/{semesterId}")
	public ResponseEntity<?> updateSubject(@RequestBody Subject subject,@PathVariable Long userId,@PathVariable Long classId,@PathVariable Long semesterId){
		Subject updatedSubject = subjectService.updateSubject(subject,userId,classId,semesterId);
		return new ResponseEntity<Subject>(updatedSubject,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		subjectService.deleteBySubjectId(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Subject> subjectOptional = subjectService.findBySubjectId(id);
		
		if(subjectOptional.isEmpty())
			return new ResponseEntity<String>("Delete id"+id,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Subject>(subjectOptional.get(),HttpStatus.OK);
	}
	

}
