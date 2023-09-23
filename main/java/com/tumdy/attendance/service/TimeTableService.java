package com.tumdy.attendance.service;


import java.util.List;
import java.util.Optional;

import com.tumdy.attendance.domain.TimeTable;

public interface TimeTableService {

	TimeTable createTimeTable(TimeTable timetable,Long semesterId);

	TimeTable updateTimeTable(TimeTable timetable, Long semesterId);

	Optional<TimeTable> findById(Long id);

	void deleteById(Long id);

	List<TimeTable> findAll();
	
	int getTimeCountperEach(Long class_id,Long subject_id,String date);


}
