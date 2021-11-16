package com.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeepayroll.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
