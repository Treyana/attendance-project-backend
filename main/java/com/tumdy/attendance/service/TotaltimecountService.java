package com.tumdy.attendance.service;

import java.util.List;
import java.util.Optional;

import com.tumdy.attendance.domain.Totaltimecount;

public interface TotaltimecountService {
	
	List<Totaltimecount> findAll();
	
	Totaltimecount createTimeCount(Totaltimecount totaltimecount,Long subjectId);
	
	Totaltimecount updateTimeCount(Totaltimecount totaltimecount,Long subjectId);
	
	Optional<Totaltimecount> findByTotaltimecountId(Long id);
	
	void deleteByTotaltimecountId(Long id);
	
	

}
