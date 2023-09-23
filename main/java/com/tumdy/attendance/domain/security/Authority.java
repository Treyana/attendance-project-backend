package com.tumdy.attendance.domain.security;

import org.springframework.security.core.GrantedAuthority;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Authority implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1297710644286264495L;
	
	private final String authority;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

}
