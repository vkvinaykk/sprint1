package com.employeepayroll.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.employeepayroll.entity.PublicHolidays;
import com.employeepayroll.repository.PublicHolidaysRepository;

@Service
public class PublicHolidaysService {
@Autowired
PublicHolidaysRepository publicHolidaysRepository;
@Transactional(readOnly = true)
public PublicHolidays getEmployee(int holidayId) {
	Optional<PublicHolidays> holiday = publicHolidaysRepository.findById(holidayId);
	if (holiday.isPresent())
		return holiday.get();
	throw new RuntimeException("It is not a PUBLIC holiday");
}
}
