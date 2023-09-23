package com.tumdy.attendance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.tumdy.attendance.domain.YearClass;
import com.tumdy.attendance.service.ClassNameService;

@RestController
@RequestMapping("/api/class")
@CrossOrigin(origins = "http://localhost:3000")
public class ClassNameController {

	private final ClassNameService classNameService;

	@Autowired
	public ClassNameController(ClassNameService classNameService) {
		super();
		this.classNameService = classNameService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<YearClass> createClass(@RequestBody YearClass className){
		YearClass createdClass = classNameService.createClass(className);
		return new ResponseEntity<YearClass>(createdClass, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<YearClass> findAllAcademicyear(){
		return classNameService.findAll();
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<YearClass> classOpt = classNameService.findByClassId(id);
		
		if(classOpt.isEmpty())
			return new ResponseEntity<String>("ClassId"+id+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<YearClass>(classOpt.get(),HttpStatus.OK);
		
	}
	
	@GetMapping("/codeNo/{codeNo}")
	public ResponseEntity<?> findByCodeNo(@PathVariable String codeNo){
		Optional<YearClass> classOpt = classNameService.findByCodeno(codeNo);
		
		if(classOpt.isEmpty())
			return new ResponseEntity<String>("ClassId"+codeNo+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<YearClass>(classOpt.get(),HttpStatus.OK);
		
	}

	
	@PatchMapping("/update")
	public ResponseEntity<?> updateClass(@RequestBody YearClass className){
		YearClass updatedClass = classNameService.updateClass(className);
		return new ResponseEntity<YearClass>(updatedClass,HttpStatus.OK);
		
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		classNameService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}
	
	
	
}
