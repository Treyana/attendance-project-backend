package com.tumdy.attendance.repository;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tumdy.attendance.domain.Attendance;
import com.tumdy.attendance.domain.AttendanceResponse;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long>{
	@Query(value="select count(id) from ATTENDANCE att where att.CLASS_ID=?1 AND att.SUBJECT_ID=?2 AND att.STUDENT_ID=?3 AND att.DATE=?4 ",nativeQuery = true)
	int IsAlreadyRecorded(long class_id, long subject_id, String student_id, String date);
	
	
	@Query("SELECT new com.tumdy.attendance.domain.AttendanceResponse(class.name,stu.fullname,sub.name)  FROM Attendance att "
		+ " join YearClass class on att.class_id=class.id "
		+ " join Subject sub on att.subject_id=sub.id "
		+ " join Student stu on att.student_id=stu.id "
		+ "where att.class_id=?1 AND att.subject_id=?2  ")
	List<AttendanceResponse> getAttendanceRecordData(long classId, long subjectId);
	
	
	@Query(value="SELECT att.* from attendance att where att.class_id=?1 and att.subject_id=?2 and att.date=?3",nativeQuery = true)
	Set<Attendance> getAttendanceListbyDaily(long className, long subjectName, String date);
	

}
