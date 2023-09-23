package com.tumdy.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import com.tumdy.attendance.domain.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long>{

}
