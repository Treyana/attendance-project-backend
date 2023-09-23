package com.tumdy.attendance.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Accordion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String subtimea;
	private String subtimeb;
	private String subtimec;
	private String subtimed;
	private String subtimee;
	
	private String subtimef;
	private String subtimeg;
	private String subtimeh;
	private String subtimei;
	private String subtimej;
	
	private String subtimek;
	private String subtimel;
	private String subtimem;
	private String subtimen;
	private String subtimeo;
	
	private String subtimep;
	private String subtimeq;
	private String subtimer;
	private String subtimes;
	private String subtimet;
	
	private String subtimeu;
	private String subtimev;
	private String subtimew;
	private String subtimex;
	private String subtimey;
	
	private String subtimez;
	private String subtimedf;
	private String subtimece;
	private String subtimegk;
	private String subtimeml;
	
	@ManyToOne
	@JoinColumn(name = "semesterId")
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name = "classId")
	private YearClass yearClass;
	
	
	

}
