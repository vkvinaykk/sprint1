package com.employeepayroll.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeepayroll.entity.Employee;
import com.employeepayroll.entity.EmployeeWorkingDays;
import com.employeepayroll.repository.EmployeeWorkingDaysRepository;

@Service
public class EmployeeWorkingDaysService {
	@Autowired
	EmployeeWorkingDaysRepository employeeWorkingDaysRepository;

	@Transactional(readOnly = true)
	public EmployeeWorkingDays getEmployee(int employeeId) {
		Optional<EmployeeWorkingDays> optEmpWork = employeeWorkingDaysRepository.findById(employeeId);
		if (optEmpWork.isPresent())
			return optEmpWork.get();
		throw new RuntimeException("Employee does not EXIST");
	}

	@Transactional(readOnly = true)
	public List<EmployeeWorkingDays> getEmployees() {
		List<EmployeeWorkingDays> elist = employeeWorkingDaysRepository.findAll();
		if (elist.size() > 0)
			return elist;
		throw new RuntimeException("No data found");
	}

	@Transactional
	public boolean addOrModifyEmployee(EmployeeWorkingDays employee) {
		EmployeeWorkingDays emp = employeeWorkingDaysRepository.save(employee);
		return emp != null;
	}

	@Transactional
	public void removeEmployee(int employeeId) {
		employeeWorkingDaysRepository.deleteById(employeeId);
	}
}
