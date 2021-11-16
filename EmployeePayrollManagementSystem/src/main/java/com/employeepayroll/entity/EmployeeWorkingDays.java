package com.employeepayroll.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee_working_days")
public class EmployeeWorkingDays {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "eid")
	int eId;
	@Column(name = "worked_date")
	LocalDate workedDate;
	@Column(name = "no_of_hours")
	double numberOfHours;
	//@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="employee")
	//List<Employee>employee;
	@Column(name="emp_id")
	int employeeId;
	public EmployeeWorkingDays() {
	}

	public EmployeeWorkingDays(int eId, LocalDate workedDate, double numberOfHours,int employeeId) {
		super();
		this.eId = eId;
		this.workedDate = workedDate;
		this.numberOfHours = numberOfHours;
		this.employeeId = employeeId;
	}
	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public LocalDate getWorkedDate() {
		return workedDate;
	}

	public void setWorkedDate(LocalDate workedDate) {
		this.workedDate = workedDate;
	}

	public double getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(double numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
