package com.tumdy.attendance.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeTable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

//@NotBlank(message = "Your Timetable Name should not be blank")
// private String name;

@NotBlank(message = "Your ClassName should not be blank")
 private String className;
 
 @NotBlank(message = "Your SubjectName should not be blank")
 private String subjectName;
 
 @NotBlank(message = "Your ClassDay should not be blank")
 private String classDay;
 
 @NotBlank(message = " Your ClassTime should not be blank")
 private String classTime;
 
	
//	  @OneToOne
//	  @JoinColumn(name="semester_id") private Semester semester;
	
 	@ManyToOne
	private Semester semester;
 
}
