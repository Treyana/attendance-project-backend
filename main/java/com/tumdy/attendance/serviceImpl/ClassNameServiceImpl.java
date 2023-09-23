package com.tumdy.attendance.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.tumdy.attendance.domain.YearClass;

import com.tumdy.attendance.exception.CodenoAlreadyExistsException;
import com.tumdy.attendance.repository.ClassNameRepository;
import com.tumdy.attendance.service.ClassNameService;


@Service
public class ClassNameServiceImpl implements ClassNameService{
	
	private final ClassNameRepository classNameRepository;
	

	

	public ClassNameServiceImpl(ClassNameRepository classNameRepository) {
		super();
		this.classNameRepository = classNameRepository;
	}

	@Override
	
	public YearClass createClass(YearClass className)throws CodenoAlreadyExistsException {
		Optional<YearClass> classOpt = findByCodeno(className.getCodeNo());
		
		if(classOpt.isPresent()) {
			throw new CodenoAlreadyExistsException("Codeno already exists!");
		}
		// TODO Auto-generated method stub
		return classNameRepository.save(className);
	}

	@Override
	public List<YearClass> findAll() {
		// TODO Auto-generated method stub
		return (List<YearClass>) classNameRepository.findAll();
	}

	@Override
	public Optional<YearClass> findByClassId(Long id) {
		// TODO Auto-generated method stub
		return classNameRepository.findById(id);
	}

	@Override
	public YearClass updateClass(YearClass className) {
		// TODO Auto-generated method stub
		return classNameRepository.save(className);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		classNameRepository.deleteById(id);
		
	}

	@Override
	public Optional<YearClass> findByCodeno(String codeNo) {
		// TODO Auto-generated method stub
		return classNameRepository.findByCodeNo(codeNo);
	}

}
