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

import com.tumdy.attendance.domain.Totaltimecount;

import com.tumdy.attendance.service.TotaltimecountService;


@RestController
@RequestMapping("/api/totaltimecount")
@CrossOrigin(origins = "http://localhost:3000")

public class TotaltimecountController {
	
	private final TotaltimecountService totaltimecountService;
	
	

	public TotaltimecountController(TotaltimecountService totaltimecountService) {
		super();
		this.totaltimecountService = totaltimecountService;
	}

	@PostMapping("/create/{subjectId}")
	public ResponseEntity<Totaltimecount> createTotaltimecount(@RequestBody Totaltimecount totaltimecount,@PathVariable Long subjectId){
		Totaltimecount createdTotaltimecount = totaltimecountService.createTimeCount(totaltimecount, subjectId);
		return new ResponseEntity<Totaltimecount>(createdTotaltimecount, HttpStatus.CREATED);
	}
	
	@PatchMapping("/update/{subjectId}")
	public ResponseEntity<Totaltimecount> updateTotaltimecount(@RequestBody Totaltimecount totaltimecount,@PathVariable Long subjectId){
		Totaltimecount updatedTotaltimecount = totaltimecountService.updateTimeCount(totaltimecount, subjectId);
		return new ResponseEntity<Totaltimecount>(updatedTotaltimecount, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Totaltimecount> findAllTotaltimecount(){
		return totaltimecountService.findAll();
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Totaltimecount> timecountOpt = totaltimecountService.findByTotaltimecountId(id);
		
		if(timecountOpt.isEmpty())
			return new ResponseEntity<String>("TimecountId"+id+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Totaltimecount>(timecountOpt.get(),HttpStatus.OK);
		
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		totaltimecountService.deleteByTotaltimecountId(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}
	
}
