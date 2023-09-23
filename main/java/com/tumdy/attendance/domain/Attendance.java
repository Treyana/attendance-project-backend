package com.tumdy.attendance.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@NotBlank(message="Student_ID should not be blank")
	private long student_id;
	
	//@NotBlank(message="Class_ID should not be blank")
	private long class_id;
	
	//@NotBlank(message="Subject_ID should not be blank")
	private long subject_id;
	
	//@NotBlank(message="Invalid Date")
	private String date;
	
	//@NotBlank(message="TimeCount should not be blank")
	private int timecount;
	


}
