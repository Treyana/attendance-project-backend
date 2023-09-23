package com.tumdy.attendance.service;

import java.util.List;
import java.util.Optional;

import com.tumdy.attendance.domain.Semester;

public interface SemesterService {
 
	List<Semester> findAll();
	
	Semester createSemester(Semester semester);
	
	Semester updateSemester(Semester semester);
	
	Optional<Semester> findBySemesterId(Long id);	
	
	void deleteBySemesterId(Long id);
	
	//Optional<Semester> findBySemesterName(String Semname);
	
}
