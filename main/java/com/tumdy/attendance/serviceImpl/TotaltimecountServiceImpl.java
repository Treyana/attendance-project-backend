package com.tumdy.attendance.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.tumdy.attendance.domain.Subject;
import com.tumdy.attendance.domain.Totaltimecount;
import com.tumdy.attendance.repository.SubjectRepository;
import com.tumdy.attendance.repository.TotaltimecountRepository;
import com.tumdy.attendance.service.TotaltimecountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TotaltimecountServiceImpl implements TotaltimecountService{
	
	private final TotaltimecountRepository totaltimecountRepository;
	private final SubjectRepository subjectRepository;

	@Override
	public List<Totaltimecount> findAll() {
		// TODO Auto-generated method stub
		return (List<Totaltimecount>) totaltimecountRepository.findAll();
	}

	@Override
	public Totaltimecount createTimeCount( Totaltimecount totaltimecount,Long subjectId) {
		// TODO Auto-generated method stub
		Optional<Subject> subjectOpt = subjectRepository.findById(subjectId);
		if(subjectOpt.isPresent()) {
			Subject subject = subjectOpt.get();
			subject.getTotaltimecount().add(totaltimecount);			
			totaltimecount.setSubject(subject);
		}
		return totaltimecountRepository.save(totaltimecount);
	}

	@Override
	public Totaltimecount updateTimeCount( Totaltimecount totaltimecount,Long subjectId) {
		// TODO Auto-generated method stub
		Optional<Subject> subjectOpt = subjectRepository.findById(subjectId);
		if(subjectOpt.isPresent()) {
			Subject subject = subjectOpt.get();
			subject.getTotaltimecount().add(totaltimecount);
			totaltimecount.setSubject(subject);
		}
		return totaltimecountRepository.save(totaltimecount);
	}

	@Override
	public Optional<Totaltimecount> findByTotaltimecountId(Long id) {
		// TODO Auto-generated method stub
		return totaltimecountRepository.findById(id);
	}

	@Override
	public void deleteByTotaltimecountId(Long id) {
		// TODO Auto-generated method stub
		totaltimecountRepository.findById(id);
		
	}

}
