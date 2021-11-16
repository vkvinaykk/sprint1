package com.employeepayroll.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeepayroll.repository.EmployeeRepository;

import com.employeepayroll.entity.Employee;
@Transactional
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Transactional(readOnly = true)
	public Employee getEmployee(int employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		if (optEmp.isPresent())
			return optEmp.get();
		throw new RuntimeException("Employee does not EXIST");
	}

	@Transactional(readOnly = true)
	public List<Employee> getEmployees() {
		List<Employee> elist = employeeRepository.findAll();
		if (elist.size() > 0)
			return elist;
		throw new RuntimeException("No data found");
	}

	@Transactional
	public boolean addOrModifyEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp != null;
	}

	@Transactional
	public void removeEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
