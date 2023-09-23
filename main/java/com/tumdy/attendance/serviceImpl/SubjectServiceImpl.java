package com.tumdy.attendance.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tumdy.attendance.domain.Semester;
import com.tumdy.attendance.domain.Subject;
import com.tumdy.attendance.domain.User;
import com.tumdy.attendance.domain.YearClass;
import com.tumdy.attendance.exception.CodenoAlreadyExistsException;
import com.tumdy.attendance.repository.ClassNameRepository;
import com.tumdy.attendance.repository.SemesterRepository;
import com.tumdy.attendance.repository.SubjectRepository;
import com.tumdy.attendance.repository.UserRepository;
import com.tumdy.attendance.service.SubjectService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{
	
	private final SubjectRepository subjectRepo;
	private final ClassNameRepository classNameRepository;
	private final UserRepository userRepo;
	private final SemesterRepository semesterRepo;

	@Override
	public List<Subject> findAll() {
		
		return (List<Subject>) subjectRepo.findAll();
	}

	@Override
	public Subject createSubject(Subject subject,Long userId,Long classId,Long semesterId) throws CodenoAlreadyExistsException{
		
		Optional<Subject> subjectOpt = findByCodeno(subject.getCodeno());
		Optional<User> userOpt = userRepo.findById(userId);
		Optional<YearClass> classOpt = classNameRepository.findById(classId);
		Optional<Semester> semesterOpt = semesterRepo.findById(semesterId);
		if(classOpt.isPresent() && userOpt.isPresent() && semesterOpt.isPresent()) {
			
			User user = userOpt.get();
			user.getSubjects().add(subject);
			subject.setUser(user);
			
			YearClass className = classOpt.get();
			className.getSubjects().add(subject);
			subject.setYearClass(className);
			
			Semester semester = semesterOpt.get();
			semester.getSubjects().add(subject);
			subject.setSemester(semester);
		}
		
		if(subjectOpt.isPresent()) {
			throw new CodenoAlreadyExistsException("Codeno already exists");
			
		}
		return subjectRepo.save(subject);
	}

	@Override
	public Subject updateSubject(Subject subject,Long userId,Long classId,Long semesterId) {
		Optional<YearClass> classOpt = classNameRepository.findById(classId);
		Optional<User> userOpt = userRepo.findById(userId);
		Optional<Semester> semesterOpt = semesterRepo.findById(semesterId);
		if(classOpt.isPresent() && userOpt.isPresent() && semesterOpt.isPresent()) {
			
			User user = userOpt.get();
			user.getSubjects().add(subject);
			subject.setUser(user);
			
			YearClass className = classOpt.get();
			className.getSubjects().add(subject);
			subject.setYearClass(className);
			
			Semester semester = semesterOpt.get();
			semester.getSubjects().add(subject);
			subject.setSemester(semester);
		}
		return subjectRepo.save(subject);
	}

	@Override
	public Optional<Subject> findBySubjectId(Long id) {
		
		return subjectRepo.findById(id);
	}

	@Override
	public void deleteBySubjectId(Long id) {
		subjectRepo.deleteById(id);
		
	}

	@Override
	public Optional<Subject> findByCodeno(String codeno) {
		// TODO Auto-generated method stub
		return subjectRepo.findByCodeno(codeno);
	}

}
