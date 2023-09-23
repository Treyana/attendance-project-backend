package com.tumdy.attendance.repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.tumdy.attendance.domain.security.Role;


public interface RoleRepository extends CrudRepository<Role, Long>{
	Optional<Role> findByName(String name);

}
