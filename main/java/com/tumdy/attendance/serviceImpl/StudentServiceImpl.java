package com.tumdy.attendance.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.tumdy.attendance.domain.Student;
import com.tumdy.attendance.domain.YearClass;
import com.tumdy.attendance.exception.RollnoAlreadyExistsException;
import com.tumdy.attendance.repository.ClassNameRepository;
import com.tumdy.attendance.repository.StudentRepository;
import com.tumdy.attendance.service.StudentService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
	
	private final StudentRepository studentRepo;
	private final ClassNameRepository classNameRepository;

	@Override
	public List<Student> findAll() {
		
		return (List<Student>) studentRepo.findAll();
	}

	@Override
	public Student createStudent(Student student,Long classId) throws RollnoAlreadyExistsException{
		Optional<Student> studentOpt = findByRollno(student.getRollno());
		Optional<YearClass> classOpt = classNameRepository.findById(classId);
		if(classOpt.isPresent()) {
			YearClass className = classOpt.get();
			className.getStudents().add(student);
			student.setYearClass(className);
		}
		if(studentOpt.isPresent()) {
			throw new RollnoAlreadyExistsException("Rollno already exists");
		}
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudent(Student student,Long classId)  {
		
		Optional<YearClass> classOpt = classNameRepository.findById(classId);
		if(classOpt.isPresent()) {
			YearClass className = classOpt.get();
			className.getStudents().add(student);
			student.setYearClass(className);
		}
		return studentRepo.save(student);
	}

	@Override
	public Optional<Student> findByStudentId(Long id) {
		
		return studentRepo.findById(id);
	}

	@Override
	public void deleteByStudentId(Long id) {
		studentRepo.deleteById(id);
		
	}

	@Override
	public Optional<Student> findByRollno(String rollno) {
		// TODO Auto-generated method stub
		return studentRepo.findByRollno(rollno);
	}

}
