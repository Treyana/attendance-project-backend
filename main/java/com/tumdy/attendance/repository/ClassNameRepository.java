package com.tumdy.attendance.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.tumdy.attendance.domain.YearClass;

public interface ClassNameRepository extends CrudRepository<YearClass, Long>{
	Optional<YearClass> findByCodeNo(String codeNo);

}
