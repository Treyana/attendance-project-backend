package com.tumdy.attendance.domain;


import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Semester {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Semestername name;
	
	private String startdate;
	private String enddate;
	
	@OneToMany(mappedBy="semester",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Subject> subjects;
	

	@OneToMany(mappedBy = "semester")
	@JsonIgnore
	private  Set<Accordion> accordion = new HashSet<>();
	

}
