package com.tumdy.attendance.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String fullname;
	

	private String rollno;
	private String phno;
	private String address;
	private String username;
//	private String fathername;
	private String nrc;
//	private String dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name = "classId")
	private YearClass yearClass;

}
