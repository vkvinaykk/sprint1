package com.employeepayroll.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.Service.EmployeeService;

import com.employeepayroll.entity.Employee;
@RequestMapping("/employee")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/{employeeId}", produces = "application/json")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable int employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Employee>> getEmployeeDetails() {
		return new ResponseEntity<List<Employee>>(employeeService.getEmployees(), HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public HttpStatus addEmployeeDetails(@RequestBody Employee employee) {
		if (employeeService.addOrModifyEmployee(employee))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}

	@PutMapping(consumes = "application/json")
	public HttpStatus modifyEmployeeDetails(@RequestBody Employee employee) {
		if (employeeService.addOrModifyEmployee(employee))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}

	@DeleteMapping(value = "/{employeeId}")
	public HttpStatus removeEmployeeDetails(@PathVariable int employeeId) {
		employeeService.removeEmployee(employeeId);
		return HttpStatus.OK;
	}

	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
}
