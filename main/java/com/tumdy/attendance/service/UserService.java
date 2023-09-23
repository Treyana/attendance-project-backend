package com.tumdy.attendance.service;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import com.tumdy.attendance.domain.User;
import com.tumdy.attendance.domain.security.UserRoles;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> findAll();
	
	User createUser(User user,Set<UserRoles> userRoles);
	
	User updateUser(User user);
	
	Optional<User> findByUserId(Long id);
	
	Optional<User> findByUsername(String username);
	
	void deleteByUserId(Long id);
	
	User updateStatus ( User user);
	
	User updatePassword(User user);

}
