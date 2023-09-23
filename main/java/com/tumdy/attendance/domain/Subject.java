package com.tumdy.attendance.domain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String codeno;
	 

	private String name;
	
	@ManyToOne
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name = "classId")
	private YearClass yearClass;

	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy = "subject")
	@JsonIgnore
	private Set<Totaltimecount> totaltimecount;
	
	

}
