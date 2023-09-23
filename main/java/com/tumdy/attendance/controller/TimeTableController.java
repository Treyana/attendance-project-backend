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

import com.tumdy.attendance.domain.TimeTable;
import com.tumdy.attendance.service.TimeTableService;

import lombok.Data;

@RestController
@Data
@RequestMapping("/api/timetable")
@CrossOrigin(origins = "http://localhost:3000")
public class TimeTableController {
	@Autowired
	private final TimeTableService timetableService;
	
	@PostMapping("/create/{semesterId}")
	public ResponseEntity<?> createTimeTable(@RequestBody TimeTable timetable,@PathVariable Long semesterId){
		System.out.println("Controller serve");
		TimeTable timeTable = timetableService.createTimeTable(timetable, semesterId);
		return new ResponseEntity<TimeTable>(timeTable,HttpStatus.CREATED);
		
	}
	
	@PatchMapping("/update/{semesterId}")
	public ResponseEntity<?> updateTimeTable(@RequestBody TimeTable timetable,@PathVariable Long semesterId){
		TimeTable updatedTimeTable = timetableService.updateTimeTable(timetable,semesterId);
		return new ResponseEntity<TimeTable>(updatedTimeTable,HttpStatus.OK);
		
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> findbyId(@PathVariable Long id){
		Optional<TimeTable> timetable = timetableService.findById(id);
		return new ResponseEntity<TimeTable>(timetable.get(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		timetableService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public List<TimeTable> getAllTimeTable(){
		return timetableService.findAll();
		
	}
}
