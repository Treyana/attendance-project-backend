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

import com.tumdy.attendance.domain.Activity;

import com.tumdy.attendance.service.ActivityService;


@RestController
@RequestMapping("/api/activity")
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityController {
	
private final ActivityService activityService;
	
	


	public ActivityController(ActivityService activityService) {
	super();
	this.activityService = activityService;
}

	@PostMapping("/create")
	public ResponseEntity<Activity> createActivity(@RequestBody Activity activity){
		Activity createdActivity = activityService.createActivity(activity);
		return new ResponseEntity<Activity>(createdActivity, HttpStatus.CREATED);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity){
		Activity updatedActivity = activityService.createActivity(activity);
		return new ResponseEntity<Activity>(updatedActivity, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Activity> findAllTotaltimecount(){
		return activityService.findAll();
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Activity> activityOpt = activityService.findByTotalActivityId(id);
		
		if(activityOpt.isEmpty())
			return new ResponseEntity<String>("activityid"+id+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Activity>(activityOpt.get(),HttpStatus.OK);
		
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		activityService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}

}
