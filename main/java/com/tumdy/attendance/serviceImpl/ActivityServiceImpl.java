package com.tumdy.attendance.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tumdy.attendance.domain.Activity;
import com.tumdy.attendance.repository.ActivityRepository;

import com.tumdy.attendance.service.ActivityService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService{
	private final ActivityRepository activityRepository;

	@Override
	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return (List<Activity>) activityRepository.findAll();
	}

	@Override
	public Activity createActivity(Activity activity) {
		// TODO Auto-generated method stub
		return activityRepository.save(activity);
	}

	@Override
	public Activity updateActivity(Activity activity) {
		// TODO Auto-generated method stub
		return activityRepository.save(activity);
	}

	@Override
	public Optional<Activity> findByTotalActivityId(Long id) {
		// TODO Auto-generated method stub
		return activityRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		activityRepository.deleteById(id);
		
	}

}
