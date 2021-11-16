package com.employeepayroll.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.SantionedLeaves;
import com.employeepayroll.repository.PublicHolidaysRepository;
import com.employeepayroll.repository.SantionedLeavesRepository;

@Service
public class SantionedLeavesService {
	@Autowired
	SantionedLeavesRepository santionedLeavesRepository;
	@Autowired
    PublicHolidaysRepository publicHolidaysRepository;
	@Transactional(readOnly = true)
	public SantionedLeaves getEmployee(int employeeId) {
			Optional<SantionedLeaves> leaves = santionedLeavesRepository.findById(employeeId);
			if (leaves.isPresent())
				return leaves.get();
		throw new RuntimeException("Employee does not applied for LEAVE");
	}

}

		
		
		
		/* List<SantionedLeaves> leaves = santionedLeavesRepository.findAllByEmployeeId(employeeId);
		int totalLeavesSantioned = leaves.size();
		int commonHolidays = 0;
		if ((totalLeavesSantioned)>0)
			for(SantionedLeaves s : leaves)
				if(publicHolidaysRepository.findByHolidayDate(s.getLeaveDate()))
			       commonHolidays++;*/