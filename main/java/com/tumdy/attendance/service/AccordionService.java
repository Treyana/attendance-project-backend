package com.tumdy.attendance.service;

import java.util.List;
import java.util.Optional;

import com.tumdy.attendance.domain.Accordion;



public interface AccordionService {
	Accordion createAccordion(Accordion accordion,Long classId,Long semesterId);
	
	List<Accordion> findAll();
	
	Optional<Accordion> findByAccordionId(Long id);
	
	Accordion updateAccordion(Accordion accordion,Long classId,Long semesterId);
	
	void deleteById(Long id);

}
