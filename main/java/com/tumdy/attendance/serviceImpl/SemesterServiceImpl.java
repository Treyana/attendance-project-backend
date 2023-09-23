package com.tumdy.attendance.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tumdy.attendance.domain.Semester;
import com.tumdy.attendance.domain.YearClass;
import com.tumdy.attendance.repository.ClassNameRepository;
import com.tumdy.attendance.repository.SemesterRepository;
import com.tumdy.attendance.service.SemesterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SemesterServiceImpl implements SemesterService{

	private final SemesterRepository semesterRepo;
	private final ClassNameRepository classNameRepository;

	@Override
	public List<Semester> findAll() {
		// TODO Auto-generated method stub
		return (List<Semester>) semesterRepo.findAll();
	}

	@Override
	public Semester createSemester(Semester semester) {
		
		// TODO Auto-generated method stub
		return semesterRepo.save(semester);
	}

	@Override
	public Semester updateSemester(Semester semester) {
		// TODO Auto-generated method stub
		
		return semesterRepo.save(semester);
	}

	@Override
	public Optional<Semester> findBySemesterId(Long id) {
		// TODO Auto-generated method stub
		return semesterRepo.findById(id);
	}

	@Override
	public void deleteBySemesterId(Long id) {
		semesterRepo.deleteById(id);
		
	}

	
	
	
}
