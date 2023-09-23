package com.tumdy.attendance.service;

import java.util.List;

import com.tumdy.attendance.domain.Attendance;
import com.tumdy.attendance.domain.Attendancev1;


public interface AttendanceService {

	String createAttendance(Attendancev1 attendancedataList);
	
	List<Attendance> findAll();
	
	String updateAttendance(Attendancev1 attendancedataList);


}
