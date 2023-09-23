package com.tumdy.attendance.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tumdy.attendance.domain.Semester;
import com.tumdy.attendance.domain.TimeTable;
import com.tumdy.attendance.repository.SemesterRepository;
import com.tumdy.attendance.repository.TimeTableRepository;
import com.tumdy.attendance.service.TimeTableService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class TimeTableServiceImpl implements TimeTableService{
	@Autowired
	private final SemesterRepository semesterRepo;
	private final TimeTableRepository timeTableRepo;
	
	@Override
	public TimeTable createTimeTable(TimeTable timetable,Long semesterId) {
		Optional<Semester> semesterOpt=semesterRepo.findById(semesterId);
		if(semesterOpt.isPresent()) {
			Semester semester=semesterOpt.get();
			timetable.setSemester(semester);
		}
		return timeTableRepo.save(timetable);
	}

	@Override
	public TimeTable updateTimeTable(TimeTable timetable, Long semesterId) {
		Optional<Semester> semesterOpt=semesterRepo.findById(semesterId);
		if(semesterOpt.isPresent()) {
			Semester semester=semesterOpt.get();
			timetable.setSemester(semester);
		}
		return timeTableRepo.save(timetable);
	}

	@Override
	public Optional<TimeTable> findById(Long id) {
		return timeTableRepo.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		timeTableRepo.deleteById(id);
		
	}

	@Override
	public List<TimeTable> findAll() {
		return (List<TimeTable>) timeTableRepo.findAll();
	}

	@Override
	public int getTimeCountperEach(Long class_id, Long subject_id, String date) {
		
		return timeTableRepo.getTimeCountperEach(class_id, subject_id, date);
	}
	
	

	
}
