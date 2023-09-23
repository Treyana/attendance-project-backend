package com.tumdy.attendance.serviceImpl;

import java.text.DateFormat;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tumdy.attendance.domain.Attendance;
import com.tumdy.attendance.domain.Attendancev1;
import com.tumdy.attendance.repository.AttendanceRepository;
import com.tumdy.attendance.repository.ClassNameRepository;
import com.tumdy.attendance.repository.TimeTableRepository;
import com.tumdy.attendance.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private  AttendanceRepository attendanceRepository;
	@Autowired
	private final TimeTableRepository timetableRepository;
	@Autowired
	private final ClassNameRepository classNameRepo;

	@Override
	public String createAttendance(Attendancev1 attendancedataList) {
		
		String message = "";
		int isRecorded = 0;

		try {
			
			long class_id = attendancedataList.getClassId();
			long subject_id = attendancedataList.getSubjectId();
			System.out.println("sevInmpl : "+subject_id);
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(attendancedataList.getDate());
			DateFormat formatter = new SimpleDateFormat("EEEE");
			List<Attendance> savedAttdataList = new ArrayList<Attendance>();
			int timecount = timetableRepository.getTimeCountperEach(class_id, subject_id,formatter.format(date1).toString());
			if(timecount!=0) {
				for (int i = 0; i < attendancedataList.getPermissions().size(); i++) {

					isRecorded = attendanceRepository.IsAlreadyRecorded(class_id, subject_id,
							attendancedataList.getPermissions().get(i), attendancedataList.getDate());
					if (isRecorded == 0) {
						Attendance attendance = new Attendance();
						attendance.setTimecount(timecount);
						attendance.setClass_id(class_id);
						attendance.setSubject_id(subject_id);
						attendance.setDate(attendancedataList.getDate());
						attendance.setStudent_id(Integer.parseInt(attendancedataList.getPermissions().get(i)));
						savedAttdataList.add(attendanceRepository.save(attendance));
						if (savedAttdataList.size() > 0) {
							System.out.println("success"+savedAttdataList.size());
							message = "Attendance has been successfully saved " + savedAttdataList.size() + " row";
						} else {
							System.out.println("else"+savedAttdataList.size());
							message = "Attendance Saving Fail";
						}
					}
				}

			} 

			}catch (ParseException e) {
				e.printStackTrace();
			}
			
		return message;
	}

	@Override
	public List<Attendance> findAll() {
		// TODO Auto-generated method stub
		return attendanceRepository.findAll();
	}
	
	@Override
	public String updateAttendance(Attendancev1 attendancedataList) {
		String message = "";
		int isRecorded=0;

		try {
			long class_id = attendancedataList.getClassId();
			long subject_id = attendancedataList.getSubjectId();
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(attendancedataList.getDate());
			DateFormat formatter = new SimpleDateFormat("EEEE");
			List<Attendance> savedAttdataList = new ArrayList<Attendance>();
			int timecount = timetableRepository.getTimeCountperEach(class_id, subject_id,formatter.format(date1).toString());
			Set<Attendance> recordedlist=new HashSet<>();
			 recordedlist=attendanceRepository.getAttendanceListbyDaily(class_id,subject_id,attendancedataList.getDate());
			 List<Attendance> Recordedlist=new ArrayList<>(recordedlist);
			if(timecount!=0) {
				for (int i = 0; i < attendancedataList.getPermissions().size(); i++) {
					isRecorded = attendanceRepository.IsAlreadyRecorded(class_id, subject_id,
							attendancedataList.getPermissions().get(i), attendancedataList.getDate());
					if (isRecorded==0) {
						Attendance attendance = new Attendance();
						attendance.setTimecount(timecount);
						attendance.setClass_id(class_id);
						attendance.setSubject_id(subject_id);
						attendance.setDate(attendancedataList.getDate());
						attendance.setStudent_id(Integer.parseInt(attendancedataList.getPermissions().get(i)));
						savedAttdataList.add(attendanceRepository.save(attendance));
						if (savedAttdataList.size() > 0) {
							message = "Attendance has been successfully saved " + savedAttdataList.size() + " row";
						} else
							message = "Attendance Saving Fail";
					}
				}
				

			} 
			for(int j=0; j< Recordedlist.size();j++) {
				String stu_id=Recordedlist.get(j).getStudent_id()+"";
				if(!attendancedataList.getPermissions().contains(stu_id)) {
					attendanceRepository.deleteById(Recordedlist.get(j).getId());
				}
			}
			}catch (ParseException e) {
				e.printStackTrace();
			}
			
		return message;
	}


}
