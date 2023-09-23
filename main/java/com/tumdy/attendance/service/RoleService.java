package com.tumdy.attendance.service;

import java.util.List;
import java.util.Optional;

import com.tumdy.attendance.domain.security.Role;



public interface RoleService {
	Optional<Role> findById(Long id);
	
	List<Role> findAll();

}
