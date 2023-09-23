package com.tumdy.attendance.controller;

import java.util.HashSet;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tumdy.attendance.config.JwtTokenProvider;
import com.tumdy.attendance.domain.security.Role;
import com.tumdy.attendance.domain.SentEmailStatus;
import com.tumdy.attendance.domain.User;
import com.tumdy.attendance.domain.security.UserRoles;
import com.tumdy.attendance.payload.JwtLoginSuccessResponse;
import com.tumdy.attendance.payload.LoginRequest;
import com.tumdy.attendance.service.MapValidationErrorService;
import com.tumdy.attendance.service.RoleService;
import com.tumdy.attendance.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	private static final String TOKEN_PREFIX = "Bearer ";
	
	
	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;
	private final MapValidationErrorService mapErrorService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
	    System.out.println(loginRequest.getUsername());
	    System.out.println(loginRequest.getPassword());

	    ResponseEntity<?> errorResponse = mapErrorService.validate(result);
	    Optional<User> userOpt = userService.findByUsername(loginRequest.getUsername());
	    System.out.println( "User..."+userOpt);
	    
	    if(userOpt.isEmpty())
	      return new ResponseEntity<String>("user not found",HttpStatus.NOT_FOUND);
	    
	    if(errorResponse != null)
	      return errorResponse;
	    System.out.println("In the ....");
	    
	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	    System.out.println("authentication"+authentication);
	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);
	    System.out.println("Token"+jwt);

	    List<String> roleList = userOpt.get().getUserRoles().stream().map(ur -> ur.getRole().getName()).toList();
	    
	    return ResponseEntity.ok(new JwtLoginSuccessResponse(true, jwt, userOpt.get(), roleList));

	  
	  
	}
		
	
	@GetMapping("/all")
	public List<User> getAllTeacher(){
		return userService.findAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> register(@Valid @RequestBody User user) {
		
		Role role1 = new Role();
	     role1.setId(1L);
	     role1.setName("ROLE_TEACHER");
	    
	     Set<UserRoles> userRoles = new HashSet<>();
	     userRoles.add(new UserRoles(user, role1));

	     user.setStatus(SentEmailStatus.Pending);

	   
	     return new ResponseEntity<User>(userService.createUser(user, userRoles), HttpStatus.CREATED);
		
	}
	
	@PatchMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		userService.deleteByUserId(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<User> userOptional = userService.findByUserId(id);
		
		if(userOptional.isEmpty())
			return new ResponseEntity<String>("Delete id"+id,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userOptional.get(),HttpStatus.OK);
	}
	
//	@PatchMapping("/{id}/updatePassword")
//	public ResponseEntity<?> updatePassword(@RequestBody User user,@PathVariable Long id) {
//		
//	
//		 try {
//			 Optional<User> userOptional = userService.findByUserId(id);
//	            if (user == null) {
//	                return ResponseEntity.notFound().build();
//	            }
//	            
//	            user.setPassword(passwordEncoder.encode(user.getPassword()));
//	            
//		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
//		 
//	}catch (Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("Error updating password");
//}
//	}
	
	@PatchMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(@RequestBody User user){
		User updatedPassword = userService.updatePassword(user);
		return new ResponseEntity<User>(updatedPassword,HttpStatus.OK);
	}
	
	@PatchMapping("/updateStatus")
	public ResponseEntity<?> updateStatus(@RequestBody User user){
		User updatedStatus = userService.updateStatus(user);
		return new ResponseEntity<User>(updatedStatus,HttpStatus.OK);
	}
	

}
