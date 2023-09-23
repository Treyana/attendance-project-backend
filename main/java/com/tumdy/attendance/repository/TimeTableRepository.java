package com.tumdy.attendance.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tumdy.attendance.domain.TimeTable;
@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long>{
	

	@Query(value ="Select count(t.id) from TIME_TABLE  t where t.CLASS_NAME=?1 and t.SUBJECT_NAME=?2 and t.CLASS_DAY=?3 ",nativeQuery = true)
	public int getTimeCountperEach(long class_id, long subject_id, String date);

	
	

}
