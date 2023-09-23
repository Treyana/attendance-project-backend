package com.tumdy.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tumdy.attendance.domain.Attendance;
import com.tumdy.attendance.domain.Attendancev1;
import com.tumdy.attendance.service.AttendanceService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceController {
	
	
	@Autowired
	private final AttendanceService attendanceService;
	
	
	@PostMapping("/create")  
	public ResponseEntity<?> createAttendance(@RequestBody Attendancev1 attendancedataList){
		System.out.println("ControllerServe : "+attendancedataList);
		String savedAttendance=attendanceService.createAttendance(attendancedataList);
		return new ResponseEntity<String>(savedAttendance,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Attendance> getAllAttendance(){
		return attendanceService.findAll();
	}
	
	@PatchMapping("/update")  
	public ResponseEntity<?> updateAttendance(@RequestBody Attendancev1 attendancedataList){
		System.out.println("saveattendance controller serve");
		String savedAttendance=attendanceService.updateAttendance(attendancedataList);
		return new ResponseEntity<String>(savedAttendance,HttpStatus.OK);
	}
	
}
