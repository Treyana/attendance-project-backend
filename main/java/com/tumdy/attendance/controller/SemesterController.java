package com.tumdy.attendance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tumdy.attendance.domain.Semester;
import com.tumdy.attendance.service.SemesterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/semester")
@CrossOrigin(origins="http://localhost:3000")
public class SemesterController {

	private final SemesterService semesterService;
	
	@GetMapping("/all")
	public List<Semester> getAllSemester(){
		return semesterService.findAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createSemester(@RequestBody Semester semester){
		System.out.println("date :"+semester.getStartdate());
		Semester savedSemester=semesterService.createSemester(semester);
		return new ResponseEntity<Semester> (savedSemester,HttpStatus.CREATED);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<?> updateSemester(@RequestBody Semester semester){
		Semester updatedSemester=semesterService.updateSemester(semester);
		return new ResponseEntity<Semester> (updatedSemester,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		semesterService.deleteBySemesterId(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Semester> semesterOptional = semesterService.findBySemesterId(id);
		if(semesterOptional.isEmpty())
			return new ResponseEntity<String>("Delete id "+id,HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Semester>(semesterOptional.get(),HttpStatus.OK);
	}
}
