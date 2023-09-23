package com.tumdy.attendance.repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.tumdy.attendance.domain.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
	
	Optional<User> findByUsername(String username);

}
