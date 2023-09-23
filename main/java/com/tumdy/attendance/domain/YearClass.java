package com.tumdy.attendance.domain;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class YearClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String codeNo;
	
	@Enumerated(EnumType.STRING)
	private YearClassName name;
	
	@OneToMany(mappedBy = "yearClass")
	@JsonIgnore
	private Set<Student> students = new HashSet<>();
	
	@OneToMany(mappedBy = "yearClass")
	@JsonIgnore
	private Set<Accordion> accordions =new HashSet<>();
	
	@OneToMany(mappedBy = "yearClass")
	@JsonIgnore
	private Set<Subject> subjects= new HashSet<>();
			
	


}
