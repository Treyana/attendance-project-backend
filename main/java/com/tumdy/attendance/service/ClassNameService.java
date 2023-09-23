package com.tumdy.attendance.service;

import java.util.List;
import java.util.Optional;


import com.tumdy.attendance.domain.YearClass;

public interface ClassNameService {
	YearClass createClass(YearClass className);
	
	List<YearClass> findAll();
	
	Optional<YearClass> findByClassId(Long id);
	
	Optional<YearClass> findByCodeno(String codeNo);
	
	YearClass updateClass(YearClass className);
	
	void deleteById(Long id);

}
