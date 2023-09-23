package com.tumdy.attendance.serviceImpl;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tumdy.attendance.domain.SentEmailStatus;
import com.tumdy.attendance.domain.User;
import com.tumdy.attendance.domain.security.UserRoles;
import com.tumdy.attendance.exception.UsernameAlreadyExistsException;
import com.tumdy.attendance.repository.RoleRepository;
import com.tumdy.attendance.repository.UserRepository;
import com.tumdy.attendance.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepo;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepo.save(user);
	}
	
	
	@Override
	public List<User> findAll() {
		
		return (List<User>) userRepo.findAll();
	}

	
	@Override
	public User updateUser(User user) {
//		user.setStatus(SentEmailStatus.Sent);
		
		return userRepo.save(user);
	}

	@Override
	public Optional<User> findByUserId(Long id) {
		
		return userRepo.findById(id);
	}

	@Override
	public void deleteByUserId(Long id) {
		
		userRepo.deleteById(id);
		
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}


	@Override
	public User createUser(User user, Set<UserRoles> userRoles) throws UsernameAlreadyExistsException {
		Optional<User> userOpt = findByUsername(user.getUsername());
		
		
		if(userOpt.isPresent()) {
			throw new UsernameAlreadyExistsException("Username already exists!");
		}
		userRoles.forEach(ur -> roleRepository.save(ur.getRole()));
		
		user.getUserRoles().addAll(userRoles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	
		return userRepo.save(user);
	}


	@Override
	public User updatePassword(User user) {
		// TODO Auto-generated method stub
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));;
		return userRepo.save(user);
	}


	@Override
	public User updateStatus(User user) {
		// TODO Auto-generated method stub
		user.setStatus(SentEmailStatus.Sent);
		return userRepo.save(user);
	}

}
