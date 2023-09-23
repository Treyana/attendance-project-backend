package com.tumdy.attendance.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tumdy.attendance.domain.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long>{
	
	Optional<Subject> findByCodeno(String codeno);

}
