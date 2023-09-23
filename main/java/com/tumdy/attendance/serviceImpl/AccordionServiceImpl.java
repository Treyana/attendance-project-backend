package com.tumdy.attendance.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tumdy.attendance.domain.Accordion;
import com.tumdy.attendance.domain.Semester;
import com.tumdy.attendance.domain.YearClass;
import com.tumdy.attendance.repository.AccordionRepository;
import com.tumdy.attendance.repository.ClassNameRepository;
import com.tumdy.attendance.repository.SemesterRepository;
import com.tumdy.attendance.service.AccordionService;

@Service
public class AccordionServiceImpl implements AccordionService{
	
	private final AccordionRepository accordionRepository;
	private final SemesterRepository semesterRepository;
	private final ClassNameRepository classRepository;
	
	
	public AccordionServiceImpl(AccordionRepository accordionRepository, SemesterRepository semesterRepository, ClassNameRepository classRepository) {
		super();
		this.accordionRepository = accordionRepository;
		this.semesterRepository = semesterRepository;
		this.classRepository = classRepository;
	}

	@Override
	public Accordion createAccordion(Accordion accordion,Long classId,Long semesterId) {
		Optional<YearClass> classOpt = classRepository.findById(classId);
		Optional<Semester> semesterOpt = semesterRepository.findById(semesterId);
		if(classOpt.isPresent()&& semesterOpt.isPresent()) {
			YearClass yearClass = classOpt.get();
			yearClass.getAccordions().add(accordion);
			accordion.setYearClass(yearClass);
			Semester semester = semesterOpt.get();
			semester.getAccordion().add(accordion);
			accordion.setSemester(semester);
		}
		// TODO Auto-generated method stub
		return accordionRepository.save(accordion);
	}

	@Override
	public List<Accordion> findAll() {
		// TODO Auto-generated method stub
		return (List<Accordion>) accordionRepository.findAll();
	}

	@Override
	public Optional<Accordion> findByAccordionId(Long id) {
		// TODO Auto-generated method stub
		return accordionRepository.findById(id);
	}

	@Override
	public Accordion updateAccordion(Accordion accordion,Long classId,Long semesterId) {
		// TODO Auto-generated method stub
		Optional<YearClass> classOpt = classRepository.findById(classId);
		Optional<Semester> semesterOpt = semesterRepository.findById(semesterId);
		if(classOpt.isPresent()&& semesterOpt.isPresent()) {
			YearClass yearClass = classOpt.get();
			yearClass.getAccordions().add(accordion);
			accordion.setYearClass(yearClass);
			Semester semester = semesterOpt.get();
			semester.getAccordion().add(accordion);
			accordion.setSemester(semester);
		}
		return accordionRepository.save(accordion);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		accordionRepository.deleteById(id);
		
	}

}
