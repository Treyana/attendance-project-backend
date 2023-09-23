package com.tumdy.attendance.serviceImpl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.tumdy.attendance.domain.User;
import com.tumdy.attendance.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherUserDetailsService implements UserDetailsService{

	private final UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepo.findByUsername(username);
		
		if(userOpt.isEmpty()) {
			throw new UsernameNotFoundException("Username not found!");
		}
		return (UserDetails) userOpt.get();
	}
	
	public User loadUserById(Long id) throws UsernameNotFoundException{
		Optional<User> userOpt = userRepo.findById(id);
		
		if(userOpt.isEmpty()) {
			throw new UsernameNotFoundException("UserId is not found!");
		}
		
		return userOpt.get();
	}

}
