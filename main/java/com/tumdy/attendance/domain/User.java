package com.tumdy.attendance.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tumdy.attendance.domain.security.Authority;
import com.tumdy.attendance.domain.security.UserRoles;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails{
	
	private static final long serialVersionUID = -6058041338726106262L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	 @NotBlank(message = "Your name should not be blank")
	private String fullname;
	private String phno;
	
//	 @NotBlank(message = "Your Email should not be blank")
	private String username;
	private String position;
	private String nrc;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private SentEmailStatus status;
	
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Subject> subjects;
	
	@OneToMany(mappedBy =  "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRoles> userRoles = new HashSet<>();


	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> authorities = new HashSet<> ();
		userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		return authorities;
	}


	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	
}
