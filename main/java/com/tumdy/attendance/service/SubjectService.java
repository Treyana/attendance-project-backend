package com.tumdy.attendance.service;

import java.util.List;
import java.util.Optional;
import com.tumdy.attendance.domain.Subject;

public interface SubjectService {
	
	List<Subject> findAll();
	
	Subject createSubject(Subject subject,Long userId,Long classId,Long semesterId);
	
	Subject updateSubject(Subject subject,Long userId,Long classId,Long semesterId);
	
	Optional<Subject> findBySubjectId(Long id);
	
	void deleteBySubjectId(Long id);
	
	Optional<Subject> findByCodeno(String codeno);
	
	

}
