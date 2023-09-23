package com.tumdy.attendance.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tumdy.attendance.domain.security.Role;
import com.tumdy.attendance.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/role")
@RequiredArgsConstructor
public class RoleController {
	
	private  final RoleService roleService;
	
	@GetMapping("/all")
	public List<Role> getAllRole(){
		return roleService.findAll();
		
	}

}
