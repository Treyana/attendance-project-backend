package com.tumdy.attendance.service;

import java.util.List;
import java.util.Optional;

import com.tumdy.attendance.domain.Activity;


public interface ActivityService {


	List<Activity> findAll();
	
	Activity createActivity(Activity activity);
	
	Activity updateActivity(Activity activity);
	
	Optional<Activity> findByTotalActivityId(Long id);
	
	void deleteById(Long id);
}
