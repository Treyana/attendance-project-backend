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

import com.tumdy.attendance.domain.Accordion;

import com.tumdy.attendance.service.AccordionService;

@RestController
@RequestMapping("/api/accordion")
@CrossOrigin(origins = "http://localhost:3000")
public class AccordionController {
	
	private AccordionService accordionService;

	@Autowired
	public AccordionController(AccordionService accordionService) {
		super();
		this.accordionService = accordionService;
	}
	
	@PostMapping("/create/{classId}/{semesterId}")
	public ResponseEntity<Accordion> createAccordion(@RequestBody Accordion accordion,@PathVariable Long classId,@PathVariable Long semesterId){
		Accordion createdAccordion = accordionService.createAccordion(accordion,classId, semesterId);
		return new ResponseEntity<Accordion>(createdAccordion, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Accordion> findAllAccordion(){
		return accordionService.findAll();
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Accordion> accordionOpt = accordionService.findByAccordionId(id);
		
		if(accordionOpt.isEmpty())
			return new ResponseEntity<String>("AccordionId"+id+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Accordion>(accordionOpt.get(),HttpStatus.OK);
		
	}
	

	@PatchMapping("/update/{classId}/{semesterId}")
	public ResponseEntity<?> updateAccordion(@RequestBody Accordion accordion,@PathVariable Long classId,@PathVariable Long semesterId){
		Accordion updatedAccordion = accordionService.updateAccordion(accordion,classId, semesterId);
		return new ResponseEntity<Accordion>(updatedAccordion,HttpStatus.OK);
		
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		accordionService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}
	
	

}
